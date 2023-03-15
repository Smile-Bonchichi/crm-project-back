package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.material.PurchaseRawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.PurchaseRawMaterialResponseDto;
import kg.china.crmprojectback.entity.material.PurchaseRawMaterial;
import kg.china.crmprojectback.repository.material.PurchaseRawMaterialRepository;
import kg.china.crmprojectback.service.EmployeeService;
import kg.china.crmprojectback.service.PurchaseRawMaterialService;
import kg.china.crmprojectback.service.RawMaterialService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRawMaterialServiceImpl extends BaseServiceImpl<PurchaseRawMaterial> implements PurchaseRawMaterialService {
    final PurchaseRawMaterialRepository purchaseRawMaterialRepository;
    final RawMaterialService rawMaterialService;
    final EmployeeService employeeService;

    @Autowired
    public PurchaseRawMaterialServiceImpl(PurchaseRawMaterialRepository purchaseRawMaterialRepository,
                                          RawMaterialService rawMaterialService,
                                          EmployeeService employeeService) {
        super(purchaseRawMaterialRepository);
        this.purchaseRawMaterialRepository = purchaseRawMaterialRepository;
        this.rawMaterialService = rawMaterialService;
        this.employeeService = employeeService;
    }

    @Override
    public PurchaseRawMaterialResponseDto save(PurchaseRawMaterialRequestDto purchaseRawMaterialRequestDto) {
        if (purchaseRawMaterialRequestDto.getId() == null) {
            return build(
                    saveOrUpdate(
                            PurchaseRawMaterial.builder()
                                    .rawMaterial(rawMaterialService.getById(purchaseRawMaterialRequestDto.getRawMaterialId()))
                                    .amount(purchaseRawMaterialRequestDto.getAmount())
                                    .count(purchaseRawMaterialRequestDto.getCount())
                                    .employee(employeeService.getById(purchaseRawMaterialRequestDto.getEmployeeId()))
                                    .build()
                    )
            );
        }
        PurchaseRawMaterial purchaseRawMaterial = getById(purchaseRawMaterialRequestDto.getId());

        return build(
                saveOrUpdate(
                        purchaseRawMaterial
                                .rawMaterial(
                                        purchaseRawMaterialRequestDto.getRawMaterialId() != null ?
                                                rawMaterialService.getById(purchaseRawMaterialRequestDto.getRawMaterialId()) :
                                                purchaseRawMaterial.rawMaterial()
                                )
                                .amount(
                                        purchaseRawMaterialRequestDto.getAmount() != null ?
                                                purchaseRawMaterialRequestDto.getAmount() :
                                                purchaseRawMaterial.amount()
                                )
                                .count(
                                        purchaseRawMaterialRequestDto.getCount() != null ?
                                                purchaseRawMaterialRequestDto.getCount() :
                                                purchaseRawMaterial.count()
                                )
                                .employee(
                                        purchaseRawMaterialRequestDto.getEmployeeId() != null ?
                                                employeeService.getById(purchaseRawMaterialRequestDto.getEmployeeId()) :
                                                purchaseRawMaterial.employee()
                                )
                )
        );
    }

    @Override
    public List<PurchaseRawMaterialResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseRawMaterialResponseDto> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return purchaseRawMaterialRepository.findByCreateTimeBetween(dateFrom, dateTo).stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseRawMaterialResponseDto deletePurchaseRawMaterial(Long id) {
        return build(delete(id));
    }

    private PurchaseRawMaterialResponseDto build(PurchaseRawMaterial purchaseRawMaterial) {
        return PurchaseRawMaterialResponseDto.builder()
                .id(purchaseRawMaterial.getId())
                .rawMaterialName(purchaseRawMaterial.rawMaterial().name())
                .amount(purchaseRawMaterial.amount())
                .count(purchaseRawMaterial.count())
                .employeeName(purchaseRawMaterial.employee().fullName())
                .build();
    }
}
