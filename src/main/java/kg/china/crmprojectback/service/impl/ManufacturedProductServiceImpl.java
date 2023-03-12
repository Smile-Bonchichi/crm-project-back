package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.entity.product.ManufacturedProduct;
import kg.china.crmprojectback.repository.product.ManufacturedProductRepository;
import kg.china.crmprojectback.service.ManufacturedProductService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturedProductServiceImpl extends BaseServiceImpl<ManufacturedProduct> implements ManufacturedProductService {
    final ManufacturedProductRepository manufacturedProductRepository;

    @Autowired
    public ManufacturedProductServiceImpl(ManufacturedProductRepository manufacturedProductRepository) {
        super(manufacturedProductRepository);
        this.manufacturedProductRepository = manufacturedProductRepository;
    }
}
