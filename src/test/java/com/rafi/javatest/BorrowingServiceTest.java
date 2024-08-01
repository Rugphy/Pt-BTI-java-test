package com.rafi.javatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.rafi.javatest.Entity.BorrowRecord;
import com.rafi.javatest.Entity.Inventory;
import com.rafi.javatest.Repository.BorrowRecordRepository;
import com.rafi.javatest.Repository.InventoryRepository;
import com.rafi.javatest.Service.BorrowService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BorrowingServiceTest {

    @Mock
    private BorrowRecordRepository borrowRecordRepository;

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private BorrowService borrowService;

    @Test
    public void testBorrowItem() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);
        inventory.setName("Test Tool");
        inventory.setQuantity(10);

        BorrowRecord record = new BorrowRecord();
        record.setIdBorrow(1L);
        record.setIdInventory(inventory.getIdInventory());
        record.setQuantity(5);
        record.setReturned(false);

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));
        when(borrowRecordRepository.save(any(BorrowRecord.class))).thenReturn(record);

        BorrowRecord result = borrowService.borrowItem(1L, 1L, 5);
        assertEquals(5, result.getQuantity());
        assertEquals(5, inventory.getQuantity());
    }

    @Test
    public void testReturnItem() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);
        inventory.setName("Test Tool");
        inventory.setQuantity(5);

        BorrowRecord record = new BorrowRecord();
        record.setIdBorrow(1L);
        record.setIdInventory(inventory.getIdInventory());
        record.setQuantity(5);
        record.setReturned(false);

        when(borrowRecordRepository.findById(1L)).thenReturn(Optional.of(record));
        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));
        when(borrowRecordRepository.save(any(BorrowRecord.class))).thenReturn(record);

        BorrowRecord result = borrowService.returnItem(1L);
        assertEquals(true, result.isReturned());
        assertEquals(10, inventory.getQuantity());
    }

    @Test
    public void testGetBorrowingRecordById() {
        BorrowRecord record = new BorrowRecord();
        record.setIdBorrow(1L);
        record.setQuantity(5);

        when(borrowRecordRepository.findById(1L)).thenReturn(Optional.of(record));

        BorrowRecord result = borrowService.getBorrowingRecordById(1L);
        assertEquals(5, result.getQuantity());
    }

    @Test
    public void testGetAllBorrowingRecords() {
        List<BorrowRecord> records = List.of(new BorrowRecord(), new BorrowRecord());

        when(borrowRecordRepository.findAll()).thenReturn(records);

        List<BorrowRecord> result = borrowService.getAllBorrowingRecords();
        assertEquals(2, result.size());
    }
}
