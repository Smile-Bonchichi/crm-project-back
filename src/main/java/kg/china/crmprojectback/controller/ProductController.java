package kg.china.crmprojectback.controller;

import kg.china.crmprojectback.dto.product.*;
import kg.china.crmprojectback.service.FinishedProductService;
import kg.china.crmprojectback.service.ManufacturedProductService;
import kg.china.crmprojectback.service.SoldProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController {
    final ManufacturedProductService manufacturedProductService;
    final SoldProductService soldProductService;
    final FinishedProductService finishedProductService;

    @PostMapping
    public ManufacturedProductResponseDto create(@RequestBody ManufacturedProductRequestDto manufacturedProductRequestDto) {
        return manufacturedProductService.save(manufacturedProductRequestDto);
    }

    @GetMapping
    public List<ManufacturedProductResponseDto> getAllManufacturedProduct() {
        return manufacturedProductService.getAll();
    }

    @DeleteMapping
    public ManufacturedProductResponseDto deleteManufacturedProduct(@RequestParam("id") Long id) {
        return manufacturedProductService.deleteManufacturedProduct(id);
    }

    @GetMapping("/get-by-date")
    public List<ManufacturedProductResponseDto> manufacturedProductGetByDate(@RequestParam("dateFrom") LocalDateTime dateFrom,
                                                                             @RequestParam("dateTo") LocalDateTime dateTo) {
        return manufacturedProductService.findByDate(dateFrom, dateTo);
    }

    @PostMapping("/finished")
    public FinishedProductResponseDto create(@RequestBody FinishedProductRequestDto finishedProductRequestDto) {
        return finishedProductService.save(finishedProductRequestDto);
    }

    @GetMapping("/finished")
    public List<FinishedProductResponseDto> getAllFinishedProduct() {
        return finishedProductService.getAll();
    }

    @DeleteMapping("/finished")
    public FinishedProductResponseDto deleteFinishedProduct(@RequestParam("id") Long id) {
        return finishedProductService.deleteFinishedProduct(id);
    }

    @PostMapping("/sold")
    public SoldProductResponseDto create(@RequestBody SoldProductRequestDto soldProductRequestDto) {
        return soldProductService.save(soldProductRequestDto);
    }

    @GetMapping("/sold")
    public List<SoldProductResponseDto> getAllSoldProduct() {
        return soldProductService.getAll();
    }

    @DeleteMapping("/sold")
    public SoldProductResponseDto deleteSoldProduct(@RequestParam("id") Long id) {
        return soldProductService.deleteSoldProduct(id);
    }

    @GetMapping("/sold/get-by-date")
    public List<SoldProductResponseDto> getByDate(@RequestParam("dateFrom") LocalDateTime dateFrom,
                                                  @RequestParam("dateTo") LocalDateTime dateTo) {
        return soldProductService.findByDate(dateFrom, dateTo);
    }
}
