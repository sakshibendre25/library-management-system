package com.sakshi.library_management_system.repository;

import com.sakshi.library_management_system.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
}
