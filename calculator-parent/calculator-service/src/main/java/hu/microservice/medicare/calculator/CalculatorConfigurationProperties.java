package hu.microservice.medicare.calculator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "medicare.project")
@ConstructorBinding
public class CalculatorConfigurationProperties {

    private final String datastoreUrl;
    private final String neuralUrl;

    public CalculatorConfigurationProperties(String datastoreUrl, String neuralUrl) {
        this.datastoreUrl = datastoreUrl;
        this.neuralUrl = neuralUrl;
    }

    public String getDatastoreApiUrl() {
        return datastoreUrl;
    }

    public String getNeuralApiUrl() {
        return neuralUrl;
    }
}
