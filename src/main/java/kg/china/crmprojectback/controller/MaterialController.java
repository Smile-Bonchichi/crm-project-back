package kg.china.crmprojectback.controller;

import kg.china.crmprojectback.dto.material.RawMaterialRequestDto;
import kg.china.crmprojectback.dto.material.RawMaterialResponseDto;
import kg.china.crmprojectback.service.PurchaseRawMaterialService;
import kg.china.crmprojectback.service.RawMaterialService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaterialController {
    final RawMaterialService rawMaterialService;
    final PurchaseRawMaterialService purchaseRawMaterialService;

    @PostMapping
    public RawMaterialResponseDto saveRawMaterial(@RequestBody RawMaterialRequestDto rawMaterialRequestDto) {
        return rawMaterialService.save(rawMaterialRequestDto);
    }

    @GetMapping
    public List<RawMaterialResponseDto> getAllRawMaterial() {
        return rawMaterialService.getAll();
    }

    @DeleteMapping
    public RawMaterialResponseDto deleteRawMaterial(@RequestParam("id") Long id) {
        return rawMaterialService.deleteRawMaterial(id);
    }
}
