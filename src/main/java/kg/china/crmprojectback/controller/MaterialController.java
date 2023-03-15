package kg.china.crmprojectback.controller;

import kg.china.crmprojectback.dto.material.PurchaseRawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.PurchaseRawMaterialResponseDto;
import kg.china.crmprojectback.dto.material.RawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.RawMaterialResponseDto;
import kg.china.crmprojectback.service.PurchaseRawMaterialService;
import kg.china.crmprojectback.service.RawMaterialService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaterialController {
    final RawMaterialService rawMaterialService;
    final PurchaseRawMaterialService purchaseRawMaterialService;

    @PostMapping("/raw")
    public RawMaterialResponseDto saveRawMaterial(@RequestBody RawMaterialRequestDto rawMaterialRequestDto) {
        return rawMaterialService.save(rawMaterialRequestDto);
    }

    @GetMapping("/raw")
    public List<RawMaterialResponseDto> getAllRawMaterial() {
        return rawMaterialService.getAll();
    }

    @DeleteMapping("/raw")
    public RawMaterialResponseDto deleteRawMaterial(@RequestParam("id") Long id) {
        return rawMaterialService.deleteRawMaterial(id);
    }

    @PostMapping("/purchase")
    public PurchaseRawMaterialResponseDto savePurchaseRawMaterial(@RequestBody PurchaseRawMaterialRequestDto purchaseRawMaterialRequestDto) {
        return purchaseRawMaterialService.save(purchaseRawMaterialRequestDto);
    }

    @GetMapping("/purchase")
    public List<PurchaseRawMaterialResponseDto> getAllPurchaseRawMaterial() {
        return purchaseRawMaterialService.getAll();
    }

    @DeleteMapping("/purchase")
    public PurchaseRawMaterialResponseDto deletePurchaseRawMaterial(@RequestParam("id") Long id) {
        return purchaseRawMaterialService.deletePurchaseRawMaterial(id);
    }

    @GetMapping("/purchase/get-by-date")
    public List<PurchaseRawMaterialResponseDto> getByDate(@RequestParam("dateFrom") LocalDateTime dateFrom,
                                                          @RequestParam("dateTo") LocalDateTime dateTo) {
        return purchaseRawMaterialService.findByDate(dateFrom, dateTo);
    }
}
