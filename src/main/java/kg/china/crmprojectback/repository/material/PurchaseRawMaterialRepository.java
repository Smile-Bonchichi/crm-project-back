package kg.china.crmprojectback.repository.material;

import kg.china.crmprojectback.entity.material.PurchaseRawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PurchaseRawMaterialRepository extends JpaRepository<PurchaseRawMaterial, Long> {
    List<PurchaseRawMaterial> findByCreateTimeBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
