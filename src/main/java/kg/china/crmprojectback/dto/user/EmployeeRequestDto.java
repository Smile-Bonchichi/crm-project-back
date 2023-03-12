package kg.china.crmprojectback.dto.user;

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
public class EmployeeRequestDto {
    Long id;
    String name;
    Long jobTitleId;
    BigDecimal salary;
    String address;
    String phoneNumber;
}
