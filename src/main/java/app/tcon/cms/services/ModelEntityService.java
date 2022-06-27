package app.tcon.cms.services;


import app.tcon.cms.models.Content;
import app.tcon.cms.models.ModelEntity;
import app.tcon.cms.repos.ModelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ModelEntityService {
    private final ModelEntityRepo modelEntityRepo;

    @Autowired
    public ModelEntityService(ModelEntityRepo modelEntityRepo){
        this.modelEntityRepo = modelEntityRepo;
    }


    public ModelEntity  create(ModelEntity model){
        return modelEntityRepo.save(model);
    }

    public List<ModelEntity> getAllModels(){
        return modelEntityRepo.findAll();
    }

    public ModelEntity getModel(Long id){
        return modelEntityRepo.findById(id).get();
    }

    public Set<Content> getContentForModel(Long id){
        return modelEntityRepo.getAllContentById(id);
    }
}
