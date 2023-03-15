package kg.china.crmprojectback.dto.product;

import kg.china.crmprojectback.dto.BaseResponseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturedProductResponseDto extends BaseResponseDto {
    String finishedProductName;
    Long count;
    String employeeName;
}
