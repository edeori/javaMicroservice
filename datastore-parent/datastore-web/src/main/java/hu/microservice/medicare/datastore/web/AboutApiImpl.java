package hu.microservice.medicare.datastore.web;


import org.springframework.web.bind.annotation.RestController;

import hu.microservice.medicare.datastore.About;
import hu.microservice.medicare.datastore.AboutApi;
import hu.microservice.medicare.datastore.service.AboutService;

@RestController
public class AboutApiImpl implements AboutApi {
    
    private final AboutService service;
    
    public AboutApiImpl(AboutService service) {
        this.service = service;
    }

    @Override
    public About getAbout(String nameId) {
        return service.getAbout(nameId);
    }

}
