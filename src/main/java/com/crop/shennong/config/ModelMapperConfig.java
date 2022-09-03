package com.crop.shennong.config;

import com.crop.shennong.crop.modelmapping.CropEntityToDtoMap;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean("crop")
    public ModelMapper questionModelMapper() {
        ModelMapper cropMapper = new ModelMapper();
        cropMapper.addMappings(new CropEntityToDtoMap());

        return cropMapper;
    }
}
