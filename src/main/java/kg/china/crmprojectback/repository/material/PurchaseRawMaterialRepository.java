package kg.china.crmprojectback.repository.material;

import kg.china.crmprojectback.entity.material.PurchaseRawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRawMaterialRepository extends JpaRepository<PurchaseRawMaterial, Long> {
}
