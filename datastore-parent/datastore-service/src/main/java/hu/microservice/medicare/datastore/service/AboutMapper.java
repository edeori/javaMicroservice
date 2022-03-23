package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.About;
import hu.microservice.medicare.datastore.AboutEntity;

@Component
public class AboutMapper {
    
    public About map(AboutEntity entity) {
        var dto = new About();
        dto.setAbout(entity.getAbout());
        dto.setHeader(entity.getHeader());
        return dto;
    }

}
