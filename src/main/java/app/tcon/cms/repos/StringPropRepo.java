package app.tcon.cms.repos;

import app.tcon.cms.models.StringProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringPropRepo extends JpaRepository<StringProp, Long> {
}
