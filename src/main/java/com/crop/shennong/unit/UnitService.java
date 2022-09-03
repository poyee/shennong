package com.crop.shennong.unit;

import com.crop.shennong.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    UnitRepository repository;

    public List<Unit> getUnits() {
        return repository.findAll();
    }
}
