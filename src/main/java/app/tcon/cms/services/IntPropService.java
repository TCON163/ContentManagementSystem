package app.tcon.cms.services;

import app.tcon.cms.models.Content;
import app.tcon.cms.models.IntegerProp;
import app.tcon.cms.repos.ContentRepo;
import app.tcon.cms.repos.IntPropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntPropService {
    private final IntPropRepo repo;
    private final ContentRepo contentRepo;

    @Autowired
    public IntPropService(IntPropRepo repo, ContentRepo contentRepo){

        this.repo = repo;
        this.contentRepo = contentRepo;
    }

    public IntegerProp create(IntegerProp intProp, Long id){
        Content content = contentRepo.getById(id);

        intProp.setIntPropContent(content);

        IntegerProp saved = repo.save(intProp);

        content.getIntProps().add(saved);

        contentRepo.saveAndFlush(content);


        return saved;
    }

    public List<IntegerProp> getAll(){
        return repo.findAll();
    }
}
