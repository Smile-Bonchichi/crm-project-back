package kg.china.crmprojectback.dto.ingredient;

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
public class IngredientResponseDto extends BaseResponseDto {
    String rawMaterialName;
    Long count;
}
