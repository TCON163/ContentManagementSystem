package app.tcon.cms.repos;

import app.tcon.cms.models.IntegerProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntPropRepo extends JpaRepository<IntegerProp, Long> {
}
