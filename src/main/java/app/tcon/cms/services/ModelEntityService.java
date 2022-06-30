package app.tcon.cms.services;


import app.tcon.cms.models.Content;
import app.tcon.cms.models.ModelEntity;
import app.tcon.cms.models.ModelProperty;
import app.tcon.cms.repos.ModelEntityRepo;
import app.tcon.cms.repos.ModelPropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModelEntityService {
    private final ModelEntityRepo modelEntityRepo;
    private final ModelPropertyRepo propertyRepo;

    @Autowired
    public ModelEntityService(ModelEntityRepo modelEntityRepo, ModelPropertyRepo propertyRepo){
        this.modelEntityRepo = modelEntityRepo;
        this.propertyRepo = propertyRepo;
    }


    public ModelEntity  create(ModelEntity model){




        model =  modelEntityRepo.saveAndFlush(model);

        List<ModelProperty> properties = model.getProperties();

        for(ModelProperty prop : properties){
            prop.setModel(model);
            prop = propertyRepo.saveAndFlush(prop);
            System.out.println("saved " + prop);

        }

        model.setProperties(properties);

        return modelEntityRepo.saveAndFlush(model);



    }

    public List<ModelEntity> getAllModels(){
        return modelEntityRepo.findAll();
    }

    public ModelEntity getModel(Long id){
        return modelEntityRepo.findById(id).get();
    }

    public Set<Content> getContentForModel(Long id){
        ModelEntity model = modelEntityRepo.getById(id);

        return model.getContents();
    }
}
