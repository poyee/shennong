package com.crop.shennong.config;

import com.crop.shennong.crop.modelmapping.CropEntityToDtoMap;
import com.crop.shennong.purchase.modelmapping.PurchaseEntityToDtoMap;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean("crop")
    public ModelMapper crop() {
        ModelMapper cropMapper = new ModelMapper();
        cropMapper.addMappings(new CropEntityToDtoMap());

        return cropMapper;
    }

    @Bean("purchase")
    public ModelMapper purchase() {
        ModelMapper purchaseMapper = new ModelMapper();
        purchaseMapper.addMappings(new PurchaseEntityToDtoMap());

        return purchaseMapper;
    }
}
