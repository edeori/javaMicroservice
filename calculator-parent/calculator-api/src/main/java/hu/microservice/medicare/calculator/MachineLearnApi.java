package hu.microservice.medicare.calculator;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.WeightMatrix;

@RequestMapping(value = "/api/MachineLearn")
public interface MachineLearnApi {

    @PostMapping(value = "/teach", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    WeightMatrix neuralTeach(@RequestBody PatientData data);

    @PutMapping(value = "/process/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus processHealthStatus(@PathVariable(value = "id") String id);

}
