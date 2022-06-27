package app.tcon.cms.controllers;

import app.tcon.cms.models.Content;
import app.tcon.cms.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContentController {
    private final ContentService service;

    @Autowired
    public ContentController(ContentService service){
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/content")
    public ResponseEntity<List<Content>> getAll(){
        return ResponseEntity.ok(service.getAllContent());
    }

    @CrossOrigin
    @PostMapping("/content/model/{id}")
    public ResponseEntity<Content> create(@RequestBody Content content, @PathVariable Long id){
        return ResponseEntity.ok(service.create(content, id));
    }

    @CrossOrigin
    @GetMapping("/content/{id}")
    public ResponseEntity<Content> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getContent(id));
    }
}
