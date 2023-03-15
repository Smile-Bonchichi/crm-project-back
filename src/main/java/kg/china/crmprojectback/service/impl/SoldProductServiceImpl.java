package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.product.SoldProductRequestDto;
import kg.china.crmprojectback.dto.product.SoldProductResponseDto;
import kg.china.crmprojectback.entity.product.SoldProduct;
import kg.china.crmprojectback.repository.product.SoldProductRepository;
import kg.china.crmprojectback.service.EmployeeService;
import kg.china.crmprojectback.service.FinishedProductService;
import kg.china.crmprojectback.service.SoldProductService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoldProductServiceImpl extends BaseServiceImpl<SoldProduct> implements SoldProductService {
    final SoldProductRepository soldProductRepository;
    final FinishedProductService finishedProductService;
    final EmployeeService employeeService;

    @Autowired
    public SoldProductServiceImpl(SoldProductRepository soldProductRepository,
                                  FinishedProductService finishedProductService,
                                  EmployeeService employeeService) {
        super(soldProductRepository);
        this.soldProductRepository = soldProductRepository;
        this.finishedProductService = finishedProductService;
        this.employeeService = employeeService;
    }

    @Override
    public SoldProductResponseDto save(SoldProductRequestDto soldProductRequestDto) {
        if (soldProductRequestDto.getId() == null) {
            return build(
                    saveOrUpdate(
                            SoldProduct.builder()
                                    .finishedProduct(finishedProductService.getById(soldProductRequestDto.getFinishedProductId()))
                                    .amount(soldProductRequestDto.getAmount())
                                    .count(soldProductRequestDto.getCount())
                                    .employee(employeeService.getById(soldProductRequestDto.getEmployeeId()))
                                    .build()
                    )
            );
        }

        SoldProduct soldProduct = getById(soldProductRequestDto.getId());

        return build(
                saveOrUpdate(
                        soldProduct
                                .finishedProduct(
                                        soldProductRequestDto.getFinishedProductId() != null ?
                                                finishedProductService.getById(soldProductRequestDto.getFinishedProductId()) :
                                                soldProduct.finishedProduct()
                                )
                                .count(
                                        soldProductRequestDto.getCount() != null ?
                                                soldProductRequestDto.getCount() :
                                                soldProduct.count()
                                )
                                .amount(
                                        soldProductRequestDto.getAmount() != null ?
                                                soldProductRequestDto.getAmount() :
                                                soldProduct.amount()
                                )
                                .employee(
                                        soldProductRequestDto.getEmployeeId() != null ?
                                                employeeService.getById(soldProductRequestDto.getEmployeeId()) :
                                                soldProduct.employee()
                                )
                )
        );
    }

    @Override
    public List<SoldProductResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public SoldProductResponseDto deleteSoldProduct(Long id) {
        return build(delete(id));
    }

    @Override
    public List<SoldProductResponseDto> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return soldProductRepository.findByCreateTimeBetween(dateFrom, dateTo).stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    private SoldProductResponseDto build(SoldProduct soldProduct) {
        return SoldProductResponseDto.builder()
                .finishedProductName(soldProduct.finishedProduct().name())
                .count(soldProduct.count())
                .amount(soldProduct.amount())
                .employeeName(soldProduct.employee().fullName())
                .build();
    }
}
