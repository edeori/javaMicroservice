package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.datastore.WeightMatrixEntity;
import hu.microservice.medicare.datastore.WeightMatrixRepository;

@Service
public class WeightMatrixService {

    private final WeightMatrixRepository repository;
    private final WeightMatrixMapper mapper;

    public WeightMatrixService(WeightMatrixRepository repository, WeightMatrixMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public WeightMatrix getById(String id) throws MatrixNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(MatrixNotFound::new);
    }

    public WeightMatrix updateById(String id, WeightMatrix weightMatrix) throws MatrixNotFound {
        var opt = repository.findById(id);
        if(opt.isEmpty()) {
            throw new MatrixNotFound();
        }
        var entity = opt.get();
        update(entity, weightMatrix);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private void update(WeightMatrixEntity entity, WeightMatrix weightMatrix) {
        // TODO Auto-generated method stub
        
    }

}
