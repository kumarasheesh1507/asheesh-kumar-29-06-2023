package com.inventory.management.controller;

import com.inventory.management.service.InventoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/inventory-management-service")
public class InventoryManagementController {

	@Autowired
	private InventoryManagementService inventoryManagementService;

	@PostMapping("/{itemName}/{quantity}")
	public ResponseEntity addItemToInventory(@PathVariable("itemName") String itemName,
			@PathVariable("quantity") Long quantity) {
		return ResponseEntity.ok(inventoryManagementService.addItemToInventory(itemName, quantity));
	}

	@GetMapping("/{itemName}/{quantity}")
	public ResponseEntity pickItemFromInventory(@PathVariable("itemName") String itemName,
			@PathVariable("quantity") Long quantity) {
		return ResponseEntity.ok(inventoryManagementService.pickItemFromInventory(itemName, quantity));

	}

	@DeleteMapping("/{itemName}")
	public ResponseEntity deleteItemFromInventory(@PathVariable("itemName") String itemName) {
		return ResponseEntity.ok(inventoryManagementService.deleteItemFromInventory(itemName));
	}

	public ResponseEntity getAvailableInventory() {
		return ResponseEntity.ok(inventoryManagementService.getAvailableInventory());
	}

}
