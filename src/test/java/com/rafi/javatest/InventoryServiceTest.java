package com.rafi.javatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.rafi.javatest.Entity.Inventory;
import com.rafi.javatest.Repository.InventoryRepository;
import com.rafi.javatest.Service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @Test
    public void testAddInventory() {
        Inventory inventory = new Inventory();
        inventory.setName("Test Product");
        inventory.setQuantity(10);
        inventory.setProductType("Tool");

        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory result = inventoryService.addInventory(inventory);
        assertEquals("Test Product", result.getName());
    }

    @Test
    public void testIncreaseInventory() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);
        inventory.setName("Test Product");
        inventory.setQuantity(10);

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));
        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory result = inventoryService.increaseInventory(1L, 5);
        assertEquals(15, result.getQuantity());
    }

    @Test
    public void testGetInventoryById() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);
        inventory.setName("Test Product");

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));

        Inventory result = inventoryService.getInventoryById(1L);
        assertEquals("Test Product", result.getName());
    }

    @Test
    public void testGetAllInventory() {
        List<Inventory> inventoryList = List.of(new Inventory(), new Inventory());

        when(inventoryRepository.findAll()).thenReturn(inventoryList);

        List<Inventory> result = inventoryService.getAllInventory();
        assertEquals(2, result.size());
    }
}

