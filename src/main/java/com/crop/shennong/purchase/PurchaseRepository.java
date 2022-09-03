package com.crop.shennong.purchase;

import com.crop.shennong.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    List<Purchase> findAllByCrop_UidOrderByCreatedTimeDesc(Long cropUid);
}
