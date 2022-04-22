package hu.microservice.medicare.neural;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.IllnessCategory;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.PotentialIllness;
import hu.microservice.medicare.datastore.SportActivity;
import hu.microservice.medicare.datastore.TargetData;
import hu.microservice.medicare.datastore.WeightMatrix;

@Service
public class NeuralProcessorService {
    
    Logger logger = Logger.getLogger(NeuralProcessorService.class.getName());

    public NeuralTransferObject init() {
        var networkSizes = new int[] { 100, 50, 50, 19 };
        // var networkSizes = new int[] { 4, 1, 3, 4 };

        Network net = new Network(networkSizes);

        var transferObj = new NeuralTransferObject();
        var matrix = new WeightMatrix();
        matrix.setNetworkLayerSizes(networkSizes);
        matrix.setBias(net.getBias());
        matrix.setWeights(net.getWeights());
        matrix.setEta(1);
        transferObj.setWeightMatrix(matrix);

        return transferObj;
    }

    public double[] proba(WeightMatrix matrix) {
        var input = new double[] { 0.1, 0.5, 0.2, 0.9 };
        var target = new double[] { 0, 1, 0, 0 };

        Network net = new Network(matrix.getWeights(), matrix.getBias(),
                matrix.getNetworkLayerSizes());

        for (int i = 0; i < 10000; i++) {
            net.train(input, target, matrix.getEta());
        }
        net.train(input, target, matrix.getEta());

        var res = net.calculate(input);

        return res;
    }

    public WeightMatrix teach(NeuralTransferObject neuralTransferObject) {
        var weightMatrix = neuralTransferObject.getWeightMatrix();
        var patientData = neuralTransferObject.getPatientData();
        var targetData = neuralTransferObject.getTargetData();

        Network net = new Network(weightMatrix.getWeights(), weightMatrix.getBias(),
                weightMatrix.getNetworkLayerSizes());

        var input = transformPatientDataToInputDoubleArray(patientData);
        var target = transformTargetDataToTargetDoubleArray(targetData);

        for (int i = 0; i < 100; i++) {
            net.train(input, target, weightMatrix.getEta());
        }
        var result = net.train(input, target, weightMatrix.getEta());

        weightMatrix.setWeights(result);

        return weightMatrix;
    }

    public WeightMatrix innetTeach(NeuralTransferObject neuralTransferObject) {
        var weightMatrix = neuralTransferObject.getWeightMatrix();
        var patientData = neuralTransferObject.getPatientData();

        Network net = new Network(weightMatrix.getWeights(), weightMatrix.getBias(),
                weightMatrix.getNetworkLayerSizes());

        var input = transformPatientDataToInputDoubleArray(patientData);
        var target = transformPatientDataToTargetDoubleArray(patientData.getKnownIllnesses());

        for (int i = 0; i < 100; i++) {
            net.train(input, target, weightMatrix.getEta());
        }
        var result = net.train(input, target, weightMatrix.getEta());

        weightMatrix.setWeights(result);

        return weightMatrix;
    }

    // do some magic and wizardry
    public HealthStatus calculate(NeuralTransferObject neuralTransferObject) {
        var weightMatrix = neuralTransferObject.getWeightMatrix();
        var patientData = neuralTransferObject.getPatientData();

        Network net = new Network(weightMatrix.getWeights(), weightMatrix.getBias(),
                weightMatrix.getNetworkLayerSizes());

        var input = transformPatientDataToInputDoubleArray(patientData);
        var result = net.calculate(input);

        var status = makeHealthStatusOfCalculationResult(result, patientData);

        return status;
    }

    private HealthStatus makeHealthStatusOfCalculationResult(double[] result, PatientData patientData) {
        var status = new HealthStatus();
        status.setPatientId(patientData.getId());
        transformResultToPotentialIllnesses(status, result);

        return status;
    }

    private double[] transformPatientDataToTargetDoubleArray(Set<IllnessCategory> knownIllnesses) {
        double[] result = new double[IllnessCategory.values().length];

        int index = 0;
        for (var active : IllnessCategory.values()) {
            if (knownIllnesses.contains(active)) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }

        return result;
    }

    private void transformResultToPotentialIllnesses(HealthStatus status, double[] result) {
        int index = 0;
        for (double percent : result) {
            var potentialIllness = new PotentialIllness();
            potentialIllness.setPercent((int) Math.round(percent * 100));
            potentialIllness.setIllness(IllnessCategory.values()[index]);
            status.getPotentialIllnesses().add(potentialIllness);
            index++;
        }
    }

    private double[] transformTargetDataToTargetDoubleArray(TargetData targetData) {
        double[] result = new double[IllnessCategory.values().length];

        int index = 0;
        for (var active : IllnessCategory.values()) {
            if (targetData.getDeathCause() == active) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }

        return result;
    }

    private double[] transformPatientDataToInputDoubleArray(PatientData patientData) {
        double[] basicInfo = new double[] {
                patientData.getGender().getValue(),
                patientData.getWeight(),
                patientData.getHeight(),
                patientData.getRelationshipStatus().getValue(),
                booleanToDouble(patientData.isDoHaveKids()),
                patientData.getJobType().getValue(),
                patientData.getJobActivity().getValue(),
                patientData.getLivingLocation().getValue(),
                patientData.getRace().getValue(),
                Double.valueOf(patientData.getAverageSleepTime()),
                Double.valueOf(patientData.getOnScreenTime()),
                Double.valueOf(patientData.getAverageStressLevel()),
                booleanToDouble(patientData.isRegularEating()),
                Double.valueOf(patientData.getMealsPerDay()),
                patientData.getEating().getValue(),
                patientData.getDiet().getValue(),
                patientData.getAlcoholRegularity().getValue(),
                booleanToDouble(patientData.getDoSmoke()),
                booleanToDouble(patientData.isDoUseDrugs()),
                booleanToDouble(patientData.isDoHaveGlasses()),
                booleanToDouble(patientData.isDoHavePet())
        };
        double[] sportInfo = getSportActivitiesArray(patientData.getActiveSportActivities(),
                patientData.getPostSportActivities());
        double[] illnessInfo = getIllnessesArray(patientData.getKnownIllnesses(), patientData.getAncestorIllnesses(),
                patientData.getAncestorDeathCauses());
        double[] result = new double[basicInfo.length + sportInfo.length + illnessInfo.length];

        result = ArrayUtils.addAll(sportInfo, basicInfo);
        result = ArrayUtils.addAll(result, illnessInfo);

        // Normalize data for better results
        for (int i = 0; i < result.length; i++) {
            result[i] = normalize(result[i]);
            logger.log(Level.INFO, "data: " + result[i]);
        }

        return result;
    }

    private double[] getIllnessesArray(Set<IllnessCategory> knownIllnesses, Set<IllnessCategory> ancestorIllnesses,
            Set<IllnessCategory> ancestorDeathCauses) {
        double[] result = new double[IllnessCategory.values().length * 3];

        int index = 0;
        for (var active : IllnessCategory.values()) {
            if (knownIllnesses.contains(active)) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }
        for (var active : IllnessCategory.values()) {
            if (ancestorIllnesses.contains(active)) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }
        for (var active : IllnessCategory.values()) {
            if (ancestorDeathCauses.contains(active)) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }

        return result;
    }

    private double[] getSportActivitiesArray(Set<SportActivity> activeSportActivities,
            Set<SportActivity> postSportActivities) {
        double[] result = new double[SportActivity.values().length * 2];

        int index = 0;
        for (var active : SportActivity.values()) {
            if (activeSportActivities.contains(active)) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }

        for (var active : SportActivity.values()) {
            if (postSportActivities.contains(active)) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }

        return result;
    }

    private static double booleanToDouble(boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }

    private static double normalize(double value) {
        if (value >= 1 && value < 10) {
            return value / 10;
        } else if (value < 100) {
            return value / 100;
        } else if (value < 1000) {
            return value / 1000;
        } else if (value < 10000) {
            return value / 10000;
        }

        return value;
    }

}
