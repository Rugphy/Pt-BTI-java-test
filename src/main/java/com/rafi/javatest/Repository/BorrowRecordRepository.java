package com.rafi.javatest.Repository;

import com.rafi.javatest.Entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}
