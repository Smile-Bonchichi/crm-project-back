package kg.china.crmprojectback.repository.product;

import kg.china.crmprojectback.entity.product.FinishedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinishedProductRepository extends JpaRepository<FinishedProduct, Long> {
}
