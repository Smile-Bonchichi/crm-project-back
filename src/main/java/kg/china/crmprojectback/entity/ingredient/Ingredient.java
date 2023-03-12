package kg.china.crmprojectback.entity.ingredient;

import jakarta.persistence.*;
import kg.china.crmprojectback.entity.BaseEntity;
import kg.china.crmprojectback.entity.material.RawMaterial;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_ingredient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "raw_material_id", nullable = false)
    RawMaterial rawMaterial;
    @Column(name = "count", nullable = false)
    Long count;
}
