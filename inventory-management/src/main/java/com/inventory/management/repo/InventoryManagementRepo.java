package com.inventory.management.repo;

import com.inventory.management.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryManagementRepo extends JpaRepository<InventoryEntity, Long> {

    Optional<InventoryEntity> findByItemNameAndQuantity(String itemName, Long quantity);
    Optional<InventoryEntity> findByItemName(String itemName);
}
