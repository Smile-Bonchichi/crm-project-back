package kg.china.crmprojectback.dto.product;

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
public class FinishedProductRequestDto {
    Long id;
    String name;
    Long unitId;
    Long ingredientId;
    Long count;
    BigDecimal amount;
}
