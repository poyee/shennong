package com.crop.shennong.config;

import com.crop.shennong.crop.CropController;
import com.crop.shennong.purchase.PurchaseController;
import com.crop.shennong.registration.AuthController;
import com.crop.shennong.unit.UnitController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class WebConfig {
    @Bean("ackController")
    public Set<Class<?>> ackController() {
        List<Class<?>> classes = Arrays.asList(
                CropController.class,
                AuthController.class,
                UnitController.class,
                PurchaseController.class
        );

        return new HashSet<>(classes);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }
}
