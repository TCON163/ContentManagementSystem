package app.tcon.cms.repos;

import app.tcon.cms.models.DateProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatePropRepo extends JpaRepository<DateProp, Long> {
}
