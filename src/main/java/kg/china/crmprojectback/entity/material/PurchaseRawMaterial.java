package kg.china.crmprojectback.entity.material;

import jakarta.persistence.*;
import kg.china.crmprojectback.entity.BaseEntity;
import kg.china.crmprojectback.entity.user.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "t_purchase_raw_material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRawMaterial extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "raw_material_id", nullable = false)
    RawMaterial rawMaterial;
    @Column(name = "count", nullable = false)
    Long count;
    @Column(name = "amount", nullable = false)
    BigDecimal amount;
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;
}
