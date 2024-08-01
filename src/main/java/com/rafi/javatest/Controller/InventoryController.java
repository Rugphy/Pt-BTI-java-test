package com.rafi.javatest.Controller;

import com.rafi.javatest.Entity.Inventory;
import com.rafi.javatest.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @PostMapping("/{id}/increase")
    public Inventory increaseInventory(@PathVariable Long id,
                                       @RequestParam int quantity) {
        return inventoryService.increaseInventory(id, quantity);
    }

    @GetMapping
    public List<Inventory> getInventory(@RequestParam(required = false) Long id) {
        if (id != null) {
            return List.of(inventoryService.getInventoryById(id));
        }
        return inventoryService.getAllInventory();
    }
}
