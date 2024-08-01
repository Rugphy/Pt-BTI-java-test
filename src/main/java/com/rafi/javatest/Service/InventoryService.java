package com.rafi.javatest.Service;

import com.rafi.javatest.Config.RecordNotFoundException;
import com.rafi.javatest.Entity.Inventory;
import com.rafi.javatest.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public Inventory increaseInventory(Long id, int quantity) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Item not found with id: " + id));
        inventory.setQuantity(inventory.getQuantity() + quantity);
        return inventoryRepository.save(inventory);
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Item not found with id: " + id));
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}
