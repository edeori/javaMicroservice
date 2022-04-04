package hu.microservice.medicare.datastore.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.datastore.WeightMatrixEntity;
import hu.microservice.medicare.datastore.WeightMatrixRepository;

@Service
public class WeightMatrixService {

    private final WeightMatrixRepository repository;
    private final WeightMatrixMapper mapper;
    private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    private Date date = new Date(System.currentTimeMillis());

    public WeightMatrixService(WeightMatrixRepository repository, WeightMatrixMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public WeightMatrix create(WeightMatrix weightMatrix) {
        var entity = new WeightMatrixEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setBias(weightMatrix.getBias());
        entity.setEta(weightMatrix.getEta());
        entity.setNetworkLayerSizes(weightMatrix.getNetworkLayerSizes());
        entity.setWeights(weightMatrix.getWeights());        
        entity.setLastModification(formatter.format(date));

        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public WeightMatrix getById(String id) throws MatrixNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(MatrixNotFound::new);
    }

    public WeightMatrix updateById(String id, WeightMatrix weightMatrix) throws MatrixNotFound {
        var opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new MatrixNotFound();
        }
        var entity = opt.get();
        update(entity, weightMatrix);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private void update(WeightMatrixEntity entity, WeightMatrix weightMatrix) {
        entity.setBias(weightMatrix.getBias());
        entity.setEta(weightMatrix.getEta());
        entity.setNetworkLayerSizes(weightMatrix.getNetworkLayerSizes());
        entity.setWeights(weightMatrix.getWeights());
        entity.setLastModification(formatter.format(date));
    }

}
