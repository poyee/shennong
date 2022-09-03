package com.crop.shennong.crop;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crop.shennong.entity.CropCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface CropCategoryRepository extends JpaRepository<CropCategory, Integer> {
}
