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
public class PurchaseRawMaterialRequestDto {
    Long id;
    Long rawMaterialId;
    BigDecimal amount;
    Long count;
    Long employeeId;
}
