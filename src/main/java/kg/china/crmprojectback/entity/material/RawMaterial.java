package kg.china.crmprojectback.entity.material;

import jakarta.persistence.*;
import kg.china.crmprojectback.entity.BaseEntity;
import kg.china.crmprojectback.entity.dictionary.Unit;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "t_raw_material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RawMaterial extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false)
    String name;
    @OneToOne
    @JoinColumn(name = "unit_id", nullable = false)
    Unit unit;
    @Column(name = "count", nullable = false)
    Long count;
    @Column(name = "amount", nullable = false)
    BigDecimal amount;
}
