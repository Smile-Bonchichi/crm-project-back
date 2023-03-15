package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.product.SoldProductRequestDto;
import kg.china.crmprojectback.dto.product.SoldProductResponseDto;
import kg.china.crmprojectback.entity.product.SoldProduct;
import kg.china.crmprojectback.service.base.BaseService;

import java.time.LocalDateTime;
import java.util.List;

public interface SoldProductService extends BaseService<SoldProduct> {
    SoldProductResponseDto save(SoldProductRequestDto soldProductRequestDto);

    List<SoldProductResponseDto> getAll();

    SoldProductResponseDto deleteSoldProduct(Long id);

    List<SoldProductResponseDto> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo);
}
