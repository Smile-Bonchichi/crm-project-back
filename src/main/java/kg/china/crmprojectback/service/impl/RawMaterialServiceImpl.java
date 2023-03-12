package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.material.RawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.RawMaterialResponseDto;
import kg.china.crmprojectback.entity.material.RawMaterial;
import kg.china.crmprojectback.repository.material.RawMaterialRepository;
import kg.china.crmprojectback.service.RawMaterialService;
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
public class RawMaterialServiceImpl extends BaseServiceImpl<RawMaterial> implements RawMaterialService {
    final RawMaterialRepository rawMaterialRepository;
    final UnitService unitService;

    @Autowired
    public RawMaterialServiceImpl(RawMaterialRepository rawMaterialRepository,
                                  UnitService unitService) {
        super(rawMaterialRepository);
        this.rawMaterialRepository = rawMaterialRepository;
        this.unitService = unitService;
    }

    @Override
    public RawMaterialResponseDto save(RawMaterialRequestDto rawMaterialRequestDto) {
        if (rawMaterialRequestDto.getId() == null) {
            return build(
                    saveOrUpdate(
                            RawMaterial.builder()
                                    .name(rawMaterialRequestDto.getName())
                                    .unit(unitService.getById(rawMaterialRequestDto.getUnitId()))
                                    .count(rawMaterialRequestDto.getAmount())
                                    .amount(rawMaterialRequestDto.getSum())
                                    .build()
                    )
            );
        }

        RawMaterial rawMaterial = getById(rawMaterialRequestDto.getId());

        return build(saveOrUpdate(
                rawMaterial
                        .name(rawMaterialRequestDto.getName() != null ?
                                rawMaterialRequestDto.getName() :
                                rawMaterial.name()
                        )
                        .unit(rawMaterialRequestDto.getUnitId() != null ?
                                unitService.getById(rawMaterialRequestDto.getUnitId()) :
                                rawMaterial.unit()
                        )
                        .count(rawMaterialRequestDto.getAmount() != null ?
                                rawMaterialRequestDto.getAmount() :
                                rawMaterial.count()
                        )
                        .amount(rawMaterialRequestDto.getSum() != null ?
                                rawMaterialRequestDto.getSum() :
                                rawMaterial.amount()
                        )
        ));
    }

    @Override
    public List<RawMaterialResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public RawMaterialResponseDto deleteRawMaterial(Long id) {
        return build(delete(id));
    }

    private RawMaterialResponseDto build(RawMaterial rawMaterial) {
        return RawMaterialResponseDto.builder()
                .id(rawMaterial.getId())
                .name(rawMaterial.name())
                .unitName(rawMaterial.unit().name())
                .amount(rawMaterial.count())
                .sum(rawMaterial.amount())
                .build();
    }
}
