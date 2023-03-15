package kg.china.crmprojectback.dto.product;

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
public class SoldProductResponseDto extends BaseResponseDto {
    String finishedProductName;
    Long count;
    BigDecimal amount;
    String employeeName;
}
