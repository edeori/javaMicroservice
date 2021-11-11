package hu.microservice.medicare.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.microservice.medicare.feign.FeignProxyFactory;
import hu.microservice.medicare.feign.FeignProxyFactoryConfiguration;
import hu.microservice.medicare.keycloak.KeycloakApi;

@Configuration
@Import(FeignProxyFactoryConfiguration.class)
public class KeycloakConfiguration {
    
    private final String keycloakUri;
    
    public KeycloakConfiguration(@Value("${keycloak.uri}") String keycloakUri) {
        this.keycloakUri = keycloakUri;
    }
    
    @Bean
    public KeycloakApi keycloakApi(FeignProxyFactory proxyFactory) {
        return proxyFactory.createProxyFor(keycloakUri, KeycloakApi.class);
    }

}
