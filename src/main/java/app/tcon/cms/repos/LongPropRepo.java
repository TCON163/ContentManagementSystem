package app.tcon.cms.repos;

import app.tcon.cms.models.LongProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongPropRepo extends JpaRepository<LongProp, Long> {
}
