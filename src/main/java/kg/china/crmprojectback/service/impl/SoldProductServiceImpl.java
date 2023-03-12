package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.entity.product.SoldProduct;
import kg.china.crmprojectback.repository.product.SoldProductRepository;
import kg.china.crmprojectback.service.SoldProductService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoldProductServiceImpl extends BaseServiceImpl<SoldProduct> implements SoldProductService {
    final SoldProductRepository soldProductRepository;

    @Autowired
    public SoldProductServiceImpl(SoldProductRepository soldProductRepository) {
        super(soldProductRepository);
        this.soldProductRepository = soldProductRepository;
    }
}
