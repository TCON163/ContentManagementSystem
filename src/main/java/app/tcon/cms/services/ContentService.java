package app.tcon.cms.services;

import app.tcon.cms.exceptions.ContentDoesNotMatchModelException;
import app.tcon.cms.models.*;
import app.tcon.cms.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    private final ContentRepo repo;
    private final ModelEntityRepo modelEntityRepo;
    private final StringPropRepo stringPropRepo;
    private final IntPropRepo intPropRepo;
    private final LongPropRepo longPropRepo;
    private final DoublePropRepo doublePropRepo;
    private final DatePropRepo datePropRepo;
    private final ByteArrayPropRepo byteArrayPropRepo;

    @Autowired
    public ContentService(ContentRepo repo,
                          ModelEntityRepo modelEntityRepo,
                          StringPropRepo stringPropRepo,
                          IntPropRepo intPropRepo,
                          LongPropRepo longPropRepo,
                          DoublePropRepo doublePropRepo,
                          DatePropRepo datePropRepo,
                          ByteArrayPropRepo byteArrayPropRepo){
        this.modelEntityRepo = modelEntityRepo;
        this.repo = repo;
        this.stringPropRepo = stringPropRepo;
        this.intPropRepo = intPropRepo;
        this.longPropRepo = longPropRepo;
        this.doublePropRepo = doublePropRepo;
        this.datePropRepo = datePropRepo;
        this.byteArrayPropRepo = byteArrayPropRepo;
    }

    public boolean validateString(boolean bool, List<String> content, List<String> model){
        if(!bool) return false;
        if (content.size() != model.size()) return false;


        if(!content.equals(model)) return false;

        return true;
    }

    public boolean validate(List<ModelProperty> properties, Content content){
        boolean bool = true;



        List<String> byteArrayProps = content.getByteArrayProps().stream().map(prop-> prop.getName()).collect(Collectors.toList());
        List<String> bytesProperties = properties.stream().filter(prop -> prop.getDataType() ==0).map(prop-> prop.getName()).collect(Collectors.toList());
       bool = validateString(bool,byteArrayProps,bytesProperties);




        if(bool){
            List<String> dateProps = content.getDateProps().stream().map(prop-> prop.getName()).collect(Collectors.toList());
            List<String> dateProperties = properties.stream().filter(prop -> prop.getDataType() ==1).map(prop-> prop.getName()).collect(Collectors.toList());
            bool = validateString(bool,dateProps,dateProperties);
        }

        if(bool){
            List<String> doubleProps = content.getDoubleProps().stream().map(prop-> prop.getName()).collect(Collectors.toList());
            List<String> doubleProperties = properties.stream().filter(prop -> prop.getDataType() ==2).map(prop-> prop.getName()).collect(Collectors.toList());
            bool = validateString(bool,doubleProps,doubleProperties);
        }
        if(bool){
            List<String> integerProps = content.getIntProps().stream().map(prop-> prop.getName()).collect(Collectors.toList());
            List<String> integerProperties = properties.stream().filter(prop -> prop.getDataType() ==3).map(prop-> prop.getName()).collect(Collectors.toList());
            bool = validateString(bool,integerProps,integerProperties);
        }
        if(bool){
            List<String> longProps = content.getLongProps().stream().map(prop-> prop.getName()).collect(Collectors.toList());
            List<String> longProperties = properties.stream().filter(prop -> prop.getDataType() ==4).map(prop-> prop.getName()).collect(Collectors.toList());
            bool = validateString(bool,longProps,longProperties);
        }


        if(bool){
            List<String> stringProps = content.getStringProps().stream().map(prop-> prop.getName()).collect(Collectors.toList());
            List<String> stringProperties= properties.stream().filter(prop -> prop.getDataType() ==5).map(prop-> prop.getName()).collect(Collectors.toList());
            bool = validateString(bool,stringProps,stringProperties);
        }


        return bool;

    }

    public Content create(Content content, Long id) throws ContentDoesNotMatchModelException{
        ModelEntity model = modelEntityRepo.getById(id);

        List<ModelProperty> properties = model.getProperties();

        if(validate(properties,content)){
            content.setModel(model);


            Content saved = repo.save(content);

            Content finalSaved = saved;
            content.getStringProps().stream().forEach(prop->{
               prop.setStringPropContent(finalSaved);
                prop = stringPropRepo.save(prop);
                System.out.println(prop);
            });

            saved.setStringProps(content.getStringProps());


            content.getIntProps().stream().forEach(prop->{
                prop.setIntPropContent(finalSaved);
                prop = intPropRepo.save(prop);
                System.out.println(prop);
            });

            saved.setIntProps(content.getIntProps());


            content.getLongProps().stream().forEach(prop->{
                prop.setLongPropContent(finalSaved);
                prop = longPropRepo.save(prop);
                System.out.println(prop);
            });

            saved.setLongProps(content.getLongProps());


            content.getDoubleProps().stream().forEach(prop->{
                prop.setDoublePropContent(finalSaved);
                prop = doublePropRepo.save(prop);
                System.out.println(prop);
            });
            saved.setDoubleProps(content.getDoubleProps());

            content.getDateProps().stream().forEach(prop->{
                prop.setDatePropContent(finalSaved);
                prop = datePropRepo.save(prop);
                System.out.println(prop);
            });
            saved.setDateProps(content.getDateProps());

            content.getByteArrayProps().stream().forEach(prop->{
                prop.setByteArrayPropContent(finalSaved);
                prop = byteArrayPropRepo.save(prop);
                System.out.println(prop);
            });

            saved.setByteArrayProps(content.getByteArrayProps());

            model.getContents().add(saved);

            modelEntityRepo.saveAndFlush(model);

            saved = repo.saveAndFlush(saved);

            return saved;
        }

        throw new ContentDoesNotMatchModelException("Content does not match model.");
    }

    public Content getContent(Long id){
        return repo.findById(id).get();
    }

    public List<Content> getAllContent(){
        return repo.findAll();
    }
}
