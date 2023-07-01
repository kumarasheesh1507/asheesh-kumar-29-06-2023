package com.inventory.management.mapper;

import com.inventory.management.entity.InventoryEntity;
import com.inventory.management.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryEntityMapper {

    public InventoryEntity map(String itemName, Long quantity) {
        return InventoryEntity.builder()
                .itemName(itemName)
                .quantity(quantity)
                .build();
    }

    public Inventory map(InventoryEntity inventoryEntity) {
        return Inventory.builder()
                        .quantity(inventoryEntity.getQuantity())
                                .itemName(inventoryEntity.getItemName()).build();
    }

    public List<Inventory> map(List<InventoryEntity> inventoryEntity) {
        return inventoryEntity.stream().map(this::map).collect(Collectors.toList());
    }
}
