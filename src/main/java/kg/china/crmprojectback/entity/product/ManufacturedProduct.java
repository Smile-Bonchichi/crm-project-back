package kg.china.crmprojectback.entity.product;

import jakarta.persistence.*;
import kg.china.crmprojectback.entity.BaseEntity;
import kg.china.crmprojectback.entity.user.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_manufactured_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturedProduct extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "finished_product_id", nullable = false)
    FinishedProduct finishedProduct;
    @Column(name = "count", nullable = false)
    Long count;
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;
}
