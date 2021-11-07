package hu.microservice.medicare.calculator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "medicare.project")
@ConstructorBinding
public class CalculatorConfigurationProperties {

    private final String datastoreapiUrl;
    private final String neuralapiUrl;

    public CalculatorConfigurationProperties(String weightapiUrl, String neuralapiUrl) {
        this.datastoreapiUrl = weightapiUrl;
        this.neuralapiUrl = neuralapiUrl;
    }

    public String getDatastoreApiUrl() {
        return datastoreapiUrl;
    }

    public String getNeuralApiUrl() {
        return neuralapiUrl;
    }
}
