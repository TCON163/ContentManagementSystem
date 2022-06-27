package app.tcon.cms.services;

import app.tcon.cms.models.Content;
import app.tcon.cms.models.ModelEntity;
import app.tcon.cms.repos.ContentRepo;
import app.tcon.cms.repos.ModelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    private final ContentRepo repo;
    private final ModelEntityRepo modelEntityRepo;

    @Autowired
    public ContentService(ContentRepo repo, ModelEntityRepo modelEntityRepo){
        this.modelEntityRepo = modelEntityRepo;
        this.repo = repo;
    }

    public Content create(Content content, Long id){
        ModelEntity model = modelEntityRepo.getById(id);

        content.setModel(model);


        Content saved = repo.save(content);

        model.getContents().add(saved);

        modelEntityRepo.saveAndFlush(model);

        return saved;
    }

    public Content getContent(Long id){
        return repo.findById(id).get();
    }

    public List<Content> getAllContent(){
        return repo.findAll();
    }
}
