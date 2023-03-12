package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.dictionary.BudgetResponseDto;
import kg.china.crmprojectback.entity.dictionary.Budget;
import kg.china.crmprojectback.repository.dictionary.BudgetRepository;
import kg.china.crmprojectback.service.BudgetService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BudgetServiceImpl extends BaseServiceImpl<Budget> implements BudgetService {
    final BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        super(budgetRepository);
        this.budgetRepository = budgetRepository;
    }

    @Override
    public BudgetResponseDto save(BigDecimal sum) {
        return build(
                saveOrUpdate(
                        Budget.builder()
                                .sum(sum)
                                .build()
                )
        );
    }

    @Override
    public List<BudgetResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public BudgetResponseDto deleteBudget(Long id) {
        return build(delete(id));
    }

    private BudgetResponseDto build(Budget budget) {
        return BudgetResponseDto.builder()
                .id(budget.getId())
                .sum(budget.sum())
                .build();
    }
}
