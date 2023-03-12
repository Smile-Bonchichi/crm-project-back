package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.dictionary.UnitResponseDto;
import kg.china.crmprojectback.entity.dictionary.Unit;
import kg.china.crmprojectback.repository.dictionary.UnitRepository;
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
public class UnitServiceImpl extends BaseServiceImpl<Unit> implements UnitService {
    final UnitRepository unitRepository;

    @Autowired
    public UnitServiceImpl(UnitRepository unitRepository) {
        super(unitRepository);
        this.unitRepository = unitRepository;
    }

    @Override
    public UnitResponseDto save(Long id, String name) {
        if (id == null) {
            return build(
                    saveOrUpdate(
                            Unit.builder()
                                    .name(name)
                                    .build()
                    )
            );
        }

        return build(
                saveOrUpdate(getById(id).name(name))
        );
    }

    @Override
    public List<UnitResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public UnitResponseDto deleteUnit(Long id) {
        return build(delete(id));
    }

    private UnitResponseDto build(Unit unit) {
        return UnitResponseDto.builder()
                .id(unit.getId())
                .name(unit.name())
                .build();
    }
}
