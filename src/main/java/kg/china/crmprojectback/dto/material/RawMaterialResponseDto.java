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
public class RawMaterialResponseDto extends BaseResponseDto {
    String name;
    String unitName;
    Long amount;
    BigDecimal sum;
}
