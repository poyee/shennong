package com.crop.shennong.entity.modelmapping;

import com.crop.shennong.bean.CropDto;
import com.crop.shennong.entity.Crop;
import org.modelmapper.PropertyMap;

import java.util.Collections;

public class CropEntityToDtoMap extends PropertyMap<Crop, CropDto> {
    @Override
    protected void configure() {
        map(source.getUid()).setCropUid(0);
        map(source.getCategory().getPlv1()).setPlv1(0);
        map(source.getCategory().getName()).setCategoryName("");
    }
}
