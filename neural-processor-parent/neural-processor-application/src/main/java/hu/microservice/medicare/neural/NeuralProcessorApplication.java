package hu.microservice.medicare.neural;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "hu.microservice.medicare")
@ComponentScan(basePackages = "hu.microservice.medicare")
public class NeuralProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(NeuralProcessorApplication.class, args);
    }
}
