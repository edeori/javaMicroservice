package hu.microservice.medicare.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.microservice.medicare.datastore.HealthStatusApi;
import hu.microservice.medicare.datastore.PatientApi;
import hu.microservice.medicare.datastore.WeightApi;
import hu.microservice.medicare.feign.FeignProxyFactory;
import hu.microservice.medicare.feign.FeignProxyFactoryConfiguration;
import hu.microservice.medicare.neural.NeuralApi;

@Configuration
@Import(FeignProxyFactoryConfiguration.class)
public class CalculatorServiceApiConfiguration {

    @Bean
    public PatientApi patientServiceApi(CalculatorConfigurationProperties config, FeignProxyFactory proxyFactory) {
        return proxyFactory.createProxyFor(config.getDatastoreApiUrl(), PatientApi.class);
    }
    
    @Bean
    public WeightApi weightServiceApi(CalculatorConfigurationProperties config, FeignProxyFactory proxyFactory) {
        return proxyFactory.createProxyFor(config.getDatastoreApiUrl(), WeightApi.class);
    }
    
    @Bean
    public HealthStatusApi healthStatusServiceApi(CalculatorConfigurationProperties config, FeignProxyFactory proxyFactory) {
        return proxyFactory.createProxyFor(config.getDatastoreApiUrl(), HealthStatusApi.class);
    }
    
    @Bean
    public NeuralApi neuralServiceApi(CalculatorConfigurationProperties config, FeignProxyFactory proxyFactory) {
        return proxyFactory.createProxyFor(config.getNeuralApiUrl(), NeuralApi.class);
    }

}
