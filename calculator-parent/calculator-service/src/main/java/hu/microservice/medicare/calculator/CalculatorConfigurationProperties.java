package hu.microservice.medicare.calculator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "medicare.project")
@ConstructorBinding
public class CalculatorConfigurationProperties {

    private final String datastoreUrl;
    private final String neuralUrl;
    private final String matrixId;

    public CalculatorConfigurationProperties(String datastoreUrl, String neuralUrl, String matrixId) {
        this.datastoreUrl = datastoreUrl;
        this.neuralUrl = neuralUrl;
        this.matrixId = matrixId;
    }

    public String getDatastoreApiUrl() {
        return datastoreUrl;
    }

    public String getNeuralApiUrl() {
        return neuralUrl;
    }

    public String getMatrixId() {
        return matrixId;
    }
}
