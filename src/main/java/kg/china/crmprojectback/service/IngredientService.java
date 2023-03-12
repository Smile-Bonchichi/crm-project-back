package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.ingredient.IngredientResponseDto;
import kg.china.crmprojectback.entity.ingredient.Ingredient;
import kg.china.crmprojectback.service.base.BaseService;

import java.util.List;

public interface IngredientService extends BaseService<Ingredient> {
    IngredientResponseDto save(Long id, Long rawMaterialId, Long count);

    List<IngredientResponseDto> getAll();

    IngredientResponseDto deleteIngredient(Long id);
}
