package com.crop.shennong.crop;

import com.crop.shennong.bean.CropDto;
import com.crop.shennong.entity.Crop;
import com.crop.shennong.entity.CropCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CropService {
    private final CropCategoryRepository categoryRepository;

    private final CropRepository cropRepository;

    private final ModelMapper mapper;

    @Autowired
    public CropService(CropCategoryRepository categoryRepository,
                       CropRepository cropRepository,
                       @Qualifier("crop") ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.cropRepository = cropRepository;
        this.mapper = mapper;
    }

    List<CropCategory> getCategories() {
        return categoryRepository.findAll();
    }

    public List<CropDto> getCrops(Optional<Integer> plv1) {
        List<Crop> entities;

        if (plv1.isPresent()) {
            entities = cropRepository.findAllByCategory_Plv1(plv1.get());
        } else {
            entities = cropRepository.findAll();
        }

        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private CropDto toDto(Crop entity) {
        return mapper.map(entity, CropDto.class);
    }
}
