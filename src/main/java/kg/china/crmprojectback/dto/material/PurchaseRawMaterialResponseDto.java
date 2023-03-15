package kg.china.crmprojectback.dto.material;

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
public class PurchaseRawMaterialResponseDto extends BaseResponseDto {
    String rawMaterialName;
    BigDecimal amount;
    Long count;
    String employeeName;
}
