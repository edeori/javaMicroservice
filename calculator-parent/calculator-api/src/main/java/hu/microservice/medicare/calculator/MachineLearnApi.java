package hu.microservice.medicare.calculator;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.WeightMatrix;

@RequestMapping(value = "/api/MachineLearn")
public interface MachineLearnApi {

    @PutMapping(value = "/init")
    void initNeuralSystem();

    @PostMapping(value = "/teachPatientData", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    WeightMatrix neuralTeachByPatientData(@RequestBody PatientData patientData);

    @PostMapping(value = "/teach", consumes = MediaType.APPLICATION_JSON_VALUE)
    void neuralTeach(@RequestBody NeuralTransferObject target);

    @GetMapping(value = "/process/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus processHealthStatus(@PathVariable(value = "id") String id);

}
