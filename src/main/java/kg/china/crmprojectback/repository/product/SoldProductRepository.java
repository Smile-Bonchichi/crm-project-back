package kg.china.crmprojectback.repository.product;

import kg.china.crmprojectback.entity.product.SoldProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SoldProductRepository extends JpaRepository<SoldProduct, Long> {
    List<SoldProduct> findByCreateTimeBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
