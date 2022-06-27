package app.tcon.cms.controllers;

import app.tcon.cms.models.StringProp;
import app.tcon.cms.services.StringPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StringPropController {

    private final StringPropService service;

    @Autowired
    public StringPropController(StringPropService service){
        this.service =service;
    }

    @CrossOrigin
    @GetMapping("/stringProp")
    public ResponseEntity<List<StringProp>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @CrossOrigin
    @PostMapping("/stringProp/content/{id}")
    public ResponseEntity<StringProp> create(@RequestBody StringProp stringProp, @PathVariable Long id){
        return ResponseEntity.ok(service.create(stringProp, id));
    }


}
