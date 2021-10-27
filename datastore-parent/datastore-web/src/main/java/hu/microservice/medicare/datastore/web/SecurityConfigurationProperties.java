package hu.microservice.medicare.datastore.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "rest.security")
@ConstructorBinding
public class SecurityConfigurationProperties {

    private final String jwksUri;
    private final boolean enabled;

    public SecurityConfigurationProperties(String jwksUri, boolean enabled) {
        super();
        this.jwksUri = jwksUri;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getJwksUri() {
        return jwksUri;
    }

}
