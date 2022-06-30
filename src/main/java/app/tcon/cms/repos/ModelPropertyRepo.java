package app.tcon.cms.repos;

import app.tcon.cms.models.ModelProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelPropertyRepo extends JpaRepository<ModelProperty, Long> {
}
