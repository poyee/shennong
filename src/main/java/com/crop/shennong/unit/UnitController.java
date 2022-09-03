package com.crop.shennong.unit;

import com.crop.shennong.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/unit")
public class UnitController {
    UnitService service;

    @Autowired
    public UnitController(UnitService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Unit> getUnits() {
        return service.getUnits();
    }
}
