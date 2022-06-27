package app.tcon.cms.repos;

import app.tcon.cms.models.Content;
import app.tcon.cms.models.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ModelEntityRepo extends JpaRepository<ModelEntity,Long> {

    Set<Content> getAllContentById(Long id);

}
