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

    @PostMapping("/{idInventory}/increase")
    public Inventory increaseInventory(@PathVariable Long idInventory,
                                       @RequestParam int quantity) {
        return inventoryService.increaseInventory(idInventory, quantity);
    }

    @GetMapping
    public List<Inventory> getInventory(@RequestParam(required = false) Long idInventory) {
        if (idInventory != null) {
            return List.of(inventoryService.getInventoryById(idInventory));
        }
        return inventoryService.getAllInventory();
    }
}
