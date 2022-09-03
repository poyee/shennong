package com.crop.shennong.crop;

import com.crop.shennong.bean.CropDto;
import com.crop.shennong.entity.CropCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/crop")
public class CropController {
    CropService service;

    @Autowired
    public CropController(CropService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<CropDto> getCrops(@RequestParam(name = "plv1") Optional<Integer> plv1) {
        return service.getCrops(plv1);
    }

    @GetMapping("category")
    public List<CropCategory> getCategories() {
        return service.getCategories();
    }

}
