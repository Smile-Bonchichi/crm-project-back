package kg.china.crmprojectback.repository.product;

import kg.china.crmprojectback.entity.product.SoldProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldProductRepository extends JpaRepository<SoldProduct, Long> {
}
