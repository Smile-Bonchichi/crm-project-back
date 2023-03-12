package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.material.RawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.RawMaterialResponseDto;
import kg.china.crmprojectback.entity.material.RawMaterial;
import kg.china.crmprojectback.service.base.BaseService;

import java.util.List;

public interface RawMaterialService extends BaseService<RawMaterial> {
    RawMaterialResponseDto save(RawMaterialRequestDto rawMaterialRequestDto);

    List<RawMaterialResponseDto> getAll();

    RawMaterialResponseDto deleteRawMaterial(Long id);
}
