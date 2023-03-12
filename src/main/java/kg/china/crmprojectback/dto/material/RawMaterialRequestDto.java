package kg.china.crmprojectback.dto.material;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RawMaterialRequestDto {
    Long id;
    String name;
    Long unitId;
    Long amount;
    BigDecimal sum;
}
