package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.About;
import hu.microservice.medicare.datastore.AboutRepository;
import hu.microservice.medicare.datastore.PatientDataRepository;

@Service
public class AboutService {

    private final AboutRepository repository;
    private final PatientDataRepository patientDataRepository;
    private final AboutMapper mapper;

    public AboutService(AboutRepository repository, PatientDataRepository patientDataRepository, AboutMapper mapper) {
        this.repository = repository;
        this.patientDataRepository = patientDataRepository;
        this.mapper = mapper;
    }

    public About getAbout(String nameId) {
        var about = repository.findById(nameId).map(mapper::map).orElseThrow(AboutNotFound::new);
        var amount = patientDataRepository.findAll();
        about.setFilledByNumber(amount.size());
        return about;
    }

}
