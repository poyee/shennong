package com.crop.shennong.purchase;

import com.crop.shennong.bean.HistoryPurchase;
import com.crop.shennong.bean.PurchaseDto;
import com.crop.shennong.entity.Crop;
import com.crop.shennong.entity.Purchase;
import com.crop.shennong.entity.Unit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;

    @Autowired
    @Qualifier("purchase")
    private ModelMapper mapper;

    public PurchaseDto createPurchase(PurchaseDto dto) {
        Purchase entity = buildEntity(dto);

        Purchase savedEntity = repository.save(entity);

        return toDto(savedEntity);
    }

    public List<HistoryPurchase> getHistoryPurchase(Long cropUid) {
        List<Purchase> purchases = repository.findAllByCrop_UidOrderByCreatedTimeDesc(cropUid);

        Map<Long, List<Purchase>> purchasesGroupedByUserId = purchases.stream()
                .collect(Collectors.groupingBy(purchase -> purchase.getUser().getId()));

        return purchasesGroupedByUserId.values().stream()
                .map(this::toHistoryPurchase)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    private Purchase buildEntity(PurchaseDto dto) {
        Purchase purchase = new Purchase();
        purchase.setPrice(dto.getPrice());

        Crop crop = new Crop();
        crop.setUid(dto.getCropUid());
        purchase.setCrop(crop);

        Unit unit = new Unit();
        unit.setId(dto.getUnit());
        purchase.setUnit(unit);

        return purchase;
    }

    private PurchaseDto toDto(Purchase entity) {
        return mapper.map(entity, PurchaseDto.class);
    }

    private HistoryPurchase toHistoryPurchase(List<Purchase> purchaseList) {
        Optional<Purchase> optional = purchaseList.stream().findFirst();
        if (optional.isPresent()) {
            HistoryPurchase historyPurchase = new HistoryPurchase();

            Purchase first = optional.get();
            historyPurchase.setUserId(first.getUser().getId());
            historyPurchase.setPhone(first.getUser().getPhone());
            historyPurchase.setUserName(first.getUser().getDisplayName());
            historyPurchase.setCropId(first.getCrop().getUid());
            historyPurchase.setCropName(first.getCrop().getCname());

            List<HistoryPurchase.Item> items = new ArrayList<>();
            for (Purchase purchase : purchaseList) {
                HistoryPurchase.Item item = new HistoryPurchase.Item();
                item.setPrice(purchase.getPrice());
                item.setUnit(purchase.getUnit().getId());
                item.setCreatedTime(purchase.getCreatedTime() == null ? null : purchase.getCreatedTime().toString());
                items.add(item);
            }
            historyPurchase.setItems(items);

            return historyPurchase;
        }

        return null;
    }
}
