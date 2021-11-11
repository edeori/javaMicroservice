package hu.microservice.medicare.datastore.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.microservice.medicare.feign.FeignProxyFactory;
import hu.microservice.medicare.feign.FeignProxyFactoryConfiguration;
import hu.microservice.medicare.user.UserApi;

@Configuration
@Import(FeignProxyFactoryConfiguration.class)
public class DatastoreServiceApiConfiguration {
    
    @Bean
    public UserApi userApi(DatastoreConfigurationProperties config, FeignProxyFactory proxyFactory) {
        return proxyFactory.createProxyFor(config.getUserUrl(), UserApi.class);
    }

}
