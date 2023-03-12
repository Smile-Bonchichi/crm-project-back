package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.dictionary.UnitResponseDto;
import kg.china.crmprojectback.entity.dictionary.Unit;
import kg.china.crmprojectback.service.base.BaseService;

import java.util.List;

public interface UnitService extends BaseService<Unit> {
    UnitResponseDto save(Long id, String name);

    List<UnitResponseDto> getAll();

    UnitResponseDto deleteUnit(Long id);
}

