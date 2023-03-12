package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.entity.material.PurchaseRawMaterial;
import kg.china.crmprojectback.repository.material.PurchaseRawMaterialRepository;
import kg.china.crmprojectback.service.PurchaseRawMaterialService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRawMaterialServiceImpl extends BaseServiceImpl<PurchaseRawMaterial> implements PurchaseRawMaterialService {
    final PurchaseRawMaterialRepository purchaseRawMaterialRepository;

    @Autowired
    public PurchaseRawMaterialServiceImpl(PurchaseRawMaterialRepository purchaseRawMaterialRepository) {
        super(purchaseRawMaterialRepository);
        this.purchaseRawMaterialRepository = purchaseRawMaterialRepository;
    }
}
