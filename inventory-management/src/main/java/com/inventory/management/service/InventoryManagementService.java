package com.inventory.management.service;

import com.inventory.management.entity.InventoryEntity;
import com.inventory.management.mapper.InventoryEntityMapper;
import com.inventory.management.model.Inventory;
import com.inventory.management.repo.InventoryManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryManagementService {

	@Autowired
	private InventoryManagementRepo inventoryManagementRepo;

	@Autowired
	private InventoryEntityMapper inventoryEntityMapper;

	public Object getInventory() {
		return inventoryManagementRepo.findAll();
	}

	public Inventory addItemToInventory(String itemName, Long quantity) {
		InventoryEntity inventoryEntity = inventoryEntityMapper.map(itemName, quantity);
		inventoryEntity = inventoryManagementRepo.save(inventoryEntity);
		return inventoryEntityMapper.map(inventoryEntity);
	}

	public Inventory pickItemFromInventory(String itemName, Long quantity) {
		return inventoryEntityMapper.map(
				inventoryManagementRepo.findByItemNameAndQuantity(itemName, quantity).orElse(new InventoryEntity()));
	}

	public Inventory deleteItemFromInventory(String itemName) {
		InventoryEntity inventoryEntity = inventoryManagementRepo.findByItemName(itemName)
				.orElse(new InventoryEntity());
		inventoryManagementRepo.delete(inventoryEntity);
		return inventoryEntityMapper.map(inventoryEntity);
	}

	public List<Inventory> getAvailableInventory() {
		List<InventoryEntity> inventoryEntity = inventoryManagementRepo.findAll();
		return inventoryEntityMapper.map(inventoryEntity);
	}
}
