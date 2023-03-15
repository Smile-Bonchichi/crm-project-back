package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.product.ManufacturedProductRequestDto;
import kg.china.crmprojectback.dto.product.ManufacturedProductResponseDto;
import kg.china.crmprojectback.dto.product.SoldProductResponseDto;
import kg.china.crmprojectback.entity.product.ManufacturedProduct;
import kg.china.crmprojectback.service.base.BaseService;

import java.time.LocalDateTime;
import java.util.List;

public interface ManufacturedProductService extends BaseService<ManufacturedProduct> {
    ManufacturedProductResponseDto save(ManufacturedProductRequestDto manufacturedProductRequestDto);
    List<ManufacturedProductResponseDto> getAll();
    ManufacturedProductResponseDto deleteManufacturedProduct(Long id);
    List<ManufacturedProductResponseDto> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo);
}
