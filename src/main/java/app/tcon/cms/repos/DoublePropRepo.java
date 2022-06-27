package app.tcon.cms.repos;

import app.tcon.cms.models.DoubleProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoublePropRepo extends JpaRepository<DoubleProp, Long> {
}
