package com.crop.shennong.config;

import com.crop.shennong.crop.CropController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class WebConfig {
    @Bean("ackController")
    public Set<Class<?>> ackController() {
        List<Class<?>> classes = Arrays.asList(
                CropController.class
        );

        return new HashSet<>(classes);
    }
}
