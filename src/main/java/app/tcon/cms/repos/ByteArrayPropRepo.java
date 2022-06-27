package app.tcon.cms.repos;

import app.tcon.cms.models.ByteArrayProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ByteArrayPropRepo extends JpaRepository<ByteArrayProp, Long> {
}
