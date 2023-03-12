package kg.china.crmprojectback.controller;

import kg.china.crmprojectback.dto.dictionary.BudgetResponseDto;
import kg.china.crmprojectback.dto.dictionary.JobTitleResponseDto;
import kg.china.crmprojectback.dto.dictionary.UnitResponseDto;
import kg.china.crmprojectback.service.BudgetService;
import kg.china.crmprojectback.service.JobTitleService;
import kg.china.crmprojectback.service.UnitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/dictionary")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DictionaryController {
    final BudgetService budgetService;
    final JobTitleService jobTitleService;
    final UnitService unitService;

    @PostMapping("/budget")
    public BudgetResponseDto saveBudget(@RequestParam("sum") BigDecimal sum) {
        return budgetService.save(sum);
    }

    @GetMapping("/budget")
    public List<BudgetResponseDto> getAllBudget() {
        return budgetService.getAll();
    }

    @DeleteMapping("/budget")
    public BudgetResponseDto deleteBudget(@RequestParam(value = "id") Long id) {
        return budgetService.deleteBudget(id);
    }

    @PostMapping("/job-title")
    public JobTitleResponseDto saveJobTitle(@RequestParam(value = "id", required = false) Long id,
                                            @RequestParam("name") String name) {
        return jobTitleService.save(id, name);
    }

    @GetMapping("/job-title")
    public List<JobTitleResponseDto> getAllJobTitle() {
        return jobTitleService.getAll();
    }

    @DeleteMapping("/job-title")
    public JobTitleResponseDto deleteJobTitle(@RequestParam(value = "id") Long id) {
        return jobTitleService.deleteJobTitle(id);
    }

    @PostMapping("/unit")
    public UnitResponseDto saveUnit(@RequestParam(value = "id", required = false) Long id,
                                    @RequestParam("name") String name) {
        return unitService.save(id, name);
    }

    @GetMapping("/unit")
    public List<UnitResponseDto> getAllUnit() {
        return unitService.getAll();
    }

    @DeleteMapping("/unit")
    public UnitResponseDto deleteUnit(@RequestParam(value = "id") Long id) {
        return unitService.deleteUnit(id);
    }
}
