package hu.microservice.medicare.datastore.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "medicare.project")
@ConstructorBinding
public class DatastoreConfigurationProperties {

    private final String userUrl;
    private final String matrixId;

    public DatastoreConfigurationProperties(String userUrl, String matrixId) {
        this.userUrl = userUrl;
        this.matrixId = matrixId;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public String getMatrixId() {
        return matrixId;
    }

}
