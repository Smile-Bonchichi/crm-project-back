package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.entity.product.FinishedProduct;
import kg.china.crmprojectback.repository.product.FinishedProductRepository;
import kg.china.crmprojectback.service.FinishedProductService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FinishedProductServiceImpl extends BaseServiceImpl<FinishedProduct> implements FinishedProductService {
    final FinishedProductRepository finishedProductRepository;

    @Autowired
    public FinishedProductServiceImpl(FinishedProductRepository finishedProductRepository) {
        super(finishedProductRepository);
        this.finishedProductRepository = finishedProductRepository;
    }
}
