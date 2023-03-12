package kg.china.crmprojectback.repository.product;

import kg.china.crmprojectback.entity.product.ManufacturedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturedProductRepository extends JpaRepository<ManufacturedProduct, Long> {
}
