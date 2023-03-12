package kg.china.crmprojectback.repository.dictionary;

import kg.china.crmprojectback.entity.dictionary.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
