package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.dictionary.BudgetResponseDto;
import kg.china.crmprojectback.entity.dictionary.Budget;
import kg.china.crmprojectback.service.base.BaseService;

import java.math.BigDecimal;
import java.util.List;

public interface BudgetService extends BaseService<Budget> {
    BudgetResponseDto save(BigDecimal sum);

    List<BudgetResponseDto> getAll();

    BudgetResponseDto deleteBudget(Long id);
}
