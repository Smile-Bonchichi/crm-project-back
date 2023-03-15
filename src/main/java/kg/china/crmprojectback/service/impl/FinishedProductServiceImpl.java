package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.product.FinishedProductRequestDto;
import kg.china.crmprojectback.dto.product.FinishedProductResponseDto;
import kg.china.crmprojectback.entity.product.FinishedProduct;
import kg.china.crmprojectback.repository.product.FinishedProductRepository;
import kg.china.crmprojectback.service.FinishedProductService;
import kg.china.crmprojectback.service.IngredientService;
import kg.china.crmprojectback.service.UnitService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FinishedProductServiceImpl extends BaseServiceImpl<FinishedProduct> implements FinishedProductService {
    final FinishedProductRepository finishedProductRepository;
    final IngredientService ingredientService;
    final UnitService unitService;

    @Autowired
    public FinishedProductServiceImpl(FinishedProductRepository finishedProductRepository,
                                      IngredientService ingredientService,
                                      UnitService unitService) {
        super(finishedProductRepository);
        this.finishedProductRepository = finishedProductRepository;
        this.ingredientService = ingredientService;
        this.unitService = unitService;
    }

    @Override
    public FinishedProductResponseDto save(FinishedProductRequestDto finishedProductRequestDto) {
        if (finishedProductRequestDto.getId() == null) {
            return build(
                    saveOrUpdate(
                            FinishedProduct.builder()
                                    .name(finishedProductRequestDto.getName())
                                    .amount(finishedProductRequestDto.getAmount())
                                    .count(finishedProductRequestDto.getCount())
                                    .ingredient(ingredientService.getById(finishedProductRequestDto.getIngredientId()))
                                    .unit(unitService.getById(finishedProductRequestDto.getUnitId()))
                                    .build()
                    )
            );
        }

        FinishedProduct finishedProduct = getById(finishedProductRequestDto.getId());

        return build(
                saveOrUpdate(
                        finishedProduct
                                .name(
                                        finishedProductRequestDto.getName() != null ?
                                                finishedProductRequestDto.getName() :
                                                finishedProduct.name()
                                )
                                .amount(
                                        finishedProductRequestDto.getAmount() != null ?
                                                finishedProductRequestDto.getAmount() :
                                                finishedProduct.amount()
                                )
                                .count(
                                        finishedProductRequestDto.getCount() != null ?
                                                finishedProductRequestDto.getCount() :
                                                finishedProduct.count()
                                )
                                .ingredient(
                                        finishedProductRequestDto.getIngredientId() != null ?
                                                ingredientService.getById(finishedProductRequestDto.getIngredientId()) :
                                                finishedProduct.ingredient()
                                )
                                .unit(
                                        finishedProductRequestDto.getUnitId() != null ?
                                                unitService.getById(finishedProductRequestDto.getUnitId()) :
                                                finishedProduct.unit()
                                )
                )
        );
    }

    @Override
    public List<FinishedProductResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public FinishedProductResponseDto deleteFinishedProduct(Long id) {
        return build(delete(id));
    }

    private FinishedProductResponseDto build(FinishedProduct finishedProduct) {
        return FinishedProductResponseDto.builder()
                .id(finishedProduct.getId())
                .name(finishedProduct.name())
                .unitName(finishedProduct.unit().name())
                .amount(finishedProduct.amount())
                .count(finishedProduct.count())
                .ingredientName(finishedProduct.ingredient().rawMaterial().name())
                .build();
    }
}
