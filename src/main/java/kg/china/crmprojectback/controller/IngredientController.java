package kg.china.crmprojectback.controller;

import kg.china.crmprojectback.dto.ingredient.IngredientResponseDto;
import kg.china.crmprojectback.service.IngredientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IngredientController {
    final IngredientService ingredientService;

    @PostMapping
    public IngredientResponseDto save(@RequestParam(value = "id", required = false) Long id,
                                      @RequestParam(value = "rawMaterialId", required = false) Long rawMaterialId,
                                      @RequestParam(value = "count", required = false) Long count) {
        return ingredientService.save(id, rawMaterialId, count);
    }

    @GetMapping
    public List<IngredientResponseDto> getAll() {
        return ingredientService.getAll();
    }

    @DeleteMapping
    public IngredientResponseDto delete(@RequestParam("id") Long id) {
        return ingredientService.deleteIngredient(id);
    }
}
