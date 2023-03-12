package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.ingredient.IngredientResponseDto;
import kg.china.crmprojectback.entity.ingredient.Ingredient;
import kg.china.crmprojectback.repository.ingredient.IngredientRepository;
import kg.china.crmprojectback.service.IngredientService;
import kg.china.crmprojectback.service.RawMaterialService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IngredientServiceImpl extends BaseServiceImpl<Ingredient> implements IngredientService {
    final IngredientRepository ingredientRepository;
    final RawMaterialService rawMaterialService;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository,
                                 RawMaterialService rawMaterialService) {
        super(ingredientRepository);
        this.ingredientRepository = ingredientRepository;
        this.rawMaterialService = rawMaterialService;
    }

    @Override
    public IngredientResponseDto save(Long id, Long rawMaterialId, Long count) {
        if (id == null) {
            return build(
                    saveOrUpdate(
                            Ingredient.builder()
                                    .rawMaterial(rawMaterialService.getById(rawMaterialId))
                                    .count(count)
                                    .build()
                    )
            );
        }

        Ingredient ingredient = getById(id);

        return build(saveOrUpdate(
                ingredient
                        .rawMaterial(
                                rawMaterialId != null ?
                                        rawMaterialService.getById(rawMaterialId) :
                                        ingredient.rawMaterial()
                        )
                        .count(
                                count != null ?
                                        count :
                                        ingredient.count()
                        )
        ));
    }

    @Override
    public List<IngredientResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientResponseDto deleteIngredient(Long id) {
        return build(delete(id));
    }

    private IngredientResponseDto build(Ingredient ingredient) {
        return IngredientResponseDto.builder()
                .id(ingredient.getId())
                .rawMaterialName(ingredient.rawMaterial().name())
                .count(ingredient.count())
                .build();
    }
}
