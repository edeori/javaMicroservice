package hu.microservice.medicare.datastore.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "medicare.project")
@ConstructorBinding
public class DatastoreConfigurationProperties {

    private final String userUrl;

    public DatastoreConfigurationProperties(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

}
