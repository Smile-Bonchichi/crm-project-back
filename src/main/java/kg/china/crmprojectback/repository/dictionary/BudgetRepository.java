package kg.china.crmprojectback.repository.dictionary;

import kg.china.crmprojectback.entity.dictionary.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
