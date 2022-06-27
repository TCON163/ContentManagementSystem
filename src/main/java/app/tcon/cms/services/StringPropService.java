package app.tcon.cms.services;

import app.tcon.cms.models.Content;
import app.tcon.cms.models.StringProp;
import app.tcon.cms.repos.ContentRepo;
import app.tcon.cms.repos.StringPropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StringPropService {
    private final StringPropRepo repo;
    private final ContentRepo contentRepo;

    @Autowired
    public StringPropService(StringPropRepo repo, ContentRepo contentRepo){
        this.repo = repo;
        this.contentRepo = contentRepo;
    }

    public StringProp create(StringProp stringProp, Long id){
        Content content = contentRepo.getById(id);

        stringProp.setStringPropContent(content);

        StringProp saved =  repo.save(stringProp);

        content.getStringProps().add(saved);
        contentRepo.saveAndFlush(content);

        return saved;
    }

    public List<StringProp> getAll(){
        return repo.findAll();
    }
}
