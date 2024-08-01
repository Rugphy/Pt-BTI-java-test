package com.rafi.javatest.Controller;

import com.rafi.javatest.Entity.BorrowRecord;
import com.rafi.javatest.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowing")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow")
    public BorrowRecord borrowItem(@RequestParam Long userId,
                                   @RequestParam Long inventoryId,
                                   @RequestParam int quantity) {
        return borrowService.borrowItem(userId, inventoryId, quantity);
    }

    @PostMapping("/return/{idBorrow}")
    public BorrowRecord returnItem(@PathVariable Long idBorrow) {
        return borrowService.returnItem(idBorrow);
    }

    @GetMapping
    public List<BorrowRecord> getBorrowingRecords(@RequestParam(required = false) Long idBorrow) {
        if (idBorrow != null) {
            return List.of(borrowService.getBorrowingRecordById(idBorrow));
        }
        return borrowService.getAllBorrowingRecords();
    }
}
