package com.crop.shennong.purchase.modelmapping;

import com.crop.shennong.bean.PurchaseDto;
import com.crop.shennong.entity.Purchase;
import com.crop.shennong.utils.DateToStringConverter;
import org.modelmapper.PropertyMap;

public class PurchaseEntityToDtoMap extends PropertyMap<Purchase, PurchaseDto> {
    @Override
    protected void configure() {
        map(source.getCrop().getUid()).setCropUid(0L);
        map(source.getUser().getId()).setUserId(0L);
        map(source.getUnit().getId()).setUnit(null);
        using(new DateToStringConverter()).map(source.getCreatedTime()).setCreatedTime("");
    }
}
