package com.rafi.javatest.Repository;

import com.rafi.javatest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
