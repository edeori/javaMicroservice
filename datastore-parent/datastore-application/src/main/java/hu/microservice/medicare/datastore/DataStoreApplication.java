package hu.microservice.medicare.datastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "hu.microservice.medicare")
@ComponentScan(basePackages = "hu.microservice.medicare")
@EnableJpaRepositories
public class DataStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataStoreApplication.class, args);
	}
}
