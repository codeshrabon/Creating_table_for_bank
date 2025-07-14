package Testing_API.service;

import Testing_API.model.Model;
import Testing_API.repo.modelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class modelService {

    @Autowired
    private final modelRepository modelRepository;

    public modelService(modelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> getAllModels(){
        return modelRepository.findAll();
    }

    public ResponseEntity<Model> findById(Long id){
        return modelRepository.findById(id)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Model> save(Model model) {
        Model save = modelRepository.save(model);
        return  ResponseEntity.status(HttpStatus.CREATED).body(model);
    }


    public ResponseEntity<Model> deleteModels(Long id) {

        modelRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
