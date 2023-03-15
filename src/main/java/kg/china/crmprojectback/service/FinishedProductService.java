package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.product.FinishedProductRequestDto;
import kg.china.crmprojectback.dto.product.FinishedProductResponseDto;
import kg.china.crmprojectback.entity.product.FinishedProduct;
import kg.china.crmprojectback.service.base.BaseService;

import java.util.List;

public interface FinishedProductService extends BaseService<FinishedProduct> {
    FinishedProductResponseDto save(FinishedProductRequestDto finishedProductRequestDto);
    List<FinishedProductResponseDto> getAll();
    FinishedProductResponseDto deleteFinishedProduct(Long id);
}
