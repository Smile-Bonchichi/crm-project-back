package kg.china.crmprojectback.dto.product;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturedProductRequestDto {
    Long id;
    Long finishedProductId;
    Long count;
    Long employeeId;
}
