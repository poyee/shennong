package com.crop.shennong.purchase;

import com.crop.shennong.bean.HistoryPurchase;
import com.crop.shennong.bean.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/purchase")
public class PurchaseController {
    @Autowired
    PurchaseService service;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public PurchaseDto createPurchase(@RequestBody PurchaseDto dto) {
        return service.createPurchase(dto);
    }

    @GetMapping("/{cropUid}")
    public List<HistoryPurchase> getHistoryPurchases(@PathVariable(name = "cropUid") Long cropUid) {
        return service.getHistoryPurchase(cropUid);
    }
}
