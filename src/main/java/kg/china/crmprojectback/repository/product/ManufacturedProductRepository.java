package kg.china.crmprojectback.repository.product;

import kg.china.crmprojectback.entity.product.ManufacturedProduct;
import kg.china.crmprojectback.entity.product.SoldProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ManufacturedProductRepository extends JpaRepository<ManufacturedProduct, Long> {
    List<ManufacturedProduct> findByCreateTimeBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
