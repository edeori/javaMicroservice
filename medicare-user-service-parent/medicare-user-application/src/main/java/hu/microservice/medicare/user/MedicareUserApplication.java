package hu.microservice.medicare.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "hu.microservice.medicare")
@ConfigurationPropertiesScan(basePackages = "hu.microservice.medicare")
public class MedicareUserApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MedicareUserApplication.class, args);
    }

}
