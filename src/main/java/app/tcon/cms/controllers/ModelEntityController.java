package app.tcon.cms.controllers;

import app.tcon.cms.models.Content;
import app.tcon.cms.models.ModelEntity;
import app.tcon.cms.services.ModelEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class ModelEntityController {

    private final ModelEntityService service;

    @Autowired
    public ModelEntityController(ModelEntityService service){
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/model")
    public ResponseEntity<List<ModelEntity>> getAll(){
        return ResponseEntity.ok(service.getAllModels());
    }

    @CrossOrigin
    @PostMapping("/model")
    public ResponseEntity<ModelEntity> create(@RequestBody ModelEntity model){
        return ResponseEntity.ok(service.create(model));
    }

    @CrossOrigin
    @GetMapping("/model/{id}")
    public ResponseEntity<ModelEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getModel(id));
    }


    @CrossOrigin
    @GetMapping("/model/content/{id}")
    public ResponseEntity<Set<Content>> getContentById(@PathVariable Long id){
        return ResponseEntity.ok(service.getContentForModel(id));
    }
}
