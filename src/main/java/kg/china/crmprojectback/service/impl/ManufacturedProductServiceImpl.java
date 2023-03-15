package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.product.ManufacturedProductRequestDto;
import kg.china.crmprojectback.dto.product.ManufacturedProductResponseDto;
import kg.china.crmprojectback.entity.product.ManufacturedProduct;
import kg.china.crmprojectback.repository.product.ManufacturedProductRepository;
import kg.china.crmprojectback.service.EmployeeService;
import kg.china.crmprojectback.service.FinishedProductService;
import kg.china.crmprojectback.service.ManufacturedProductService;
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
public class ManufacturedProductServiceImpl extends BaseServiceImpl<ManufacturedProduct> implements ManufacturedProductService {
    final ManufacturedProductRepository manufacturedProductRepository;
    final FinishedProductService finishedProductService;
    final EmployeeService employeeService;

    @Autowired
    public ManufacturedProductServiceImpl(ManufacturedProductRepository manufacturedProductRepository,
                                          FinishedProductService finishedProductService,
                                          EmployeeService employeeService) {
        super(manufacturedProductRepository);
        this.manufacturedProductRepository = manufacturedProductRepository;
        this.finishedProductService = finishedProductService;
        this.employeeService = employeeService;
    }

    @Override
    public ManufacturedProductResponseDto save(ManufacturedProductRequestDto manufacturedProductRequestDto) {
        return build(
                saveOrUpdate(
                        ManufacturedProduct.builder()
                                .finishedProduct(finishedProductService.getById(manufacturedProductRequestDto.getFinishedProductId()))
                                .count(manufacturedProductRequestDto.getCount())
                                .employee(employeeService.getById(manufacturedProductRequestDto.getEmployeeId()))
                                .build()
                )
        );
    }

    @Override
    public List<ManufacturedProductResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturedProductResponseDto deleteManufacturedProduct(Long id) {
        return build(delete(id));
    }

    @Override
    public List<ManufacturedProductResponseDto> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return manufacturedProductRepository.findByCreateTimeBetween(dateFrom, dateTo).stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    private ManufacturedProductResponseDto build(ManufacturedProduct manufacturedProduct) {
        return ManufacturedProductResponseDto.builder()
                .id(manufacturedProduct.getId())
                .finishedProductName(manufacturedProduct.getFinishedProduct().name())
                .count(manufacturedProduct.getCount())
                .employeeName(manufacturedProduct.getEmployee().fullName())
                .build();
    }
}
