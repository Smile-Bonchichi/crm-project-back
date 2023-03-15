package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.material.PurchaseRawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.PurchaseRawMaterialResponseDto;
import kg.china.crmprojectback.entity.material.PurchaseRawMaterial;
import kg.china.crmprojectback.service.base.BaseService;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRawMaterialService extends BaseService<PurchaseRawMaterial> {
    PurchaseRawMaterialResponseDto save(PurchaseRawMaterialRequestDto purchaseRawMaterialRequestDto);

    List<PurchaseRawMaterialResponseDto> getAll();

    List<PurchaseRawMaterialResponseDto> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo);

    PurchaseRawMaterialResponseDto deletePurchaseRawMaterial(Long id);
}
