package hu.microservice.medicare.neural;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.WeightMatrix;

@RequestMapping(value = "/api/Neural")
public interface NeuralApi {

    @PostMapping(value = "/proba", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    double[] proba(@RequestBody WeightMatrix matrix);

    @PutMapping(value = "/init", produces = MediaType.APPLICATION_JSON_VALUE)
    NeuralTransferObject initWeightsAndBias();

    @PostMapping(value = "/teach", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    WeightMatrix teach(@RequestBody NeuralTransferObject neuralTransferObject);

    @PostMapping(value = "/innerTeach", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    WeightMatrix innerTeach(@RequestBody NeuralTransferObject neuralTransferObject);

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus calculate(@RequestBody NeuralTransferObject neuralTransferObject);

}
