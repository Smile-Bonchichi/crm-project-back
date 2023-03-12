package kg.china.crmprojectback.repository.dictionary;

import kg.china.crmprojectback.entity.dictionary.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
}
