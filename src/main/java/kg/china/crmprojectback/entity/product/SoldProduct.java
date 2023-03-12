package kg.china.crmprojectback.entity.product;

import jakarta.persistence.*;
import kg.china.crmprojectback.entity.BaseEntity;
import kg.china.crmprojectback.entity.user.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "t_sold_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoldProduct extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "finished_product_id", nullable = false)
    FinishedProduct finishedProduct;
    @Column(name = "count", nullable = false)
    Long count;
    @Column(name = "amount", nullable = false)
    BigDecimal amount;
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;
}
