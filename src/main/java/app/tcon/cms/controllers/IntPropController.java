package app.tcon.cms.controllers;


import app.tcon.cms.models.IntegerProp;
import app.tcon.cms.services.IntPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class IntPropController {
    private final IntPropService service;

    @Autowired
    public IntPropController(IntPropService service){
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/intProp")
    public ResponseEntity<List<IntegerProp>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @CrossOrigin
    @PostMapping("/intProp/content/{id}")
    public ResponseEntity<IntegerProp> create(@RequestBody IntegerProp intProp, @PathVariable Long id){
        return ResponseEntity.ok(service.create(intProp, id));
    }

}
