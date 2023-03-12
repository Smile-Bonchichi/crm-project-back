package kg.china.crmprojectback.dto.dictionary;

import kg.china.crmprojectback.dto.BaseResponseDto;
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
public class BudgetResponseDto extends BaseResponseDto {
    BigDecimal sum;
}
