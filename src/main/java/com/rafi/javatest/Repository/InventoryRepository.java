package com.rafi.javatest.Repository;

import com.rafi.javatest.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
