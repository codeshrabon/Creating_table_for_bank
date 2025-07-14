package Testing_API.controller;


import Testing_API.model.Model;
import Testing_API.service.modelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/testing_table_")
public class modelController {

    private final modelService modelService;

    public modelController(modelService modelService) {
        this.modelService = modelService;
    }


    @GetMapping("/model")
    public List<Model> getAllModel(){
        return modelService.getAllModels();
    }

    @GetMapping("/modelById/{id}")
    public ResponseEntity <Model> getModelById(@PathVariable Long id){
        return  modelService.findById(id);
    }

    @PostMapping("/model/addModel")
        public ResponseEntity<Model> createModel (@RequestBody Model model){
        return modelService.save(model);
    }

    @DeleteMapping("/model/delete/{id}")
    public ResponseEntity<Model> deleteModel(@PathVariable Long id){
        return  modelService.deleteModels(id);
    }


}
