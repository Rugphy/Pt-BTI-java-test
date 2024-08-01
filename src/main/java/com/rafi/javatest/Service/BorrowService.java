package com.rafi.javatest.Service;

import com.rafi.javatest.Config.RecordNotFoundException;
import com.rafi.javatest.Entity.BorrowRecord;
import com.rafi.javatest.Entity.Inventory;
import com.rafi.javatest.Entity.User;
import com.rafi.javatest.Repository.BorrowRecordRepository;
import com.rafi.javatest.Repository.InventoryRepository;
import javax.transaction.Transactional;

import com.rafi.javatest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public BorrowRecord borrowItem(Long idUser, Long idInventory, int quantity) {
        Inventory inventory = inventoryRepository.findById(idInventory)
                .orElseThrow(() -> new RecordNotFoundException("Inventory item not found with id: " + idInventory));

        userRepository.findById(idUser)
                .orElseThrow(() -> new RecordNotFoundException("User not found with id: " + idUser));

        if (inventory.getQuantity() < quantity) {
            throw new RecordNotFoundException("Not enough quantity");
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
        BorrowRecord record = new BorrowRecord();
        record.setIdBorrow(0L);
        record.setIdUser(idUser);
        record.setIdInventory(idInventory);
        record.setQuantity(quantity);
        record.setReturned(false);
        return borrowRecordRepository.save(record);
    }

    @Transactional
    public BorrowRecord returnItem(Long idBorrow) {
        BorrowRecord record = borrowRecordRepository.findById(idBorrow)
                .orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + idBorrow));

        if (record.isReturned()) {
            throw new RecordNotFoundException("Item already returned");
        }
        Inventory inventory = inventoryRepository.findById(record.getIdInventory()).orElseThrow();
        inventory.setQuantity(inventory.getQuantity() + record.getQuantity());
        record.setReturned(true);
        return borrowRecordRepository.save(record);
    }

    public BorrowRecord getBorrowingRecordById(Long idBorrow) {
        return borrowRecordRepository.findById(idBorrow)
                .orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + idBorrow));
    }

    public List<BorrowRecord> getAllBorrowingRecords() {
        return borrowRecordRepository.findAll();
    }
}