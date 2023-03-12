package kg.china.crmprojectback.dto.user;

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
public class EmployeeResponseDto extends BaseResponseDto {
    String name;
    String jobTitleName;
    BigDecimal salary;
    String address;
    String phoneNumber;
}
