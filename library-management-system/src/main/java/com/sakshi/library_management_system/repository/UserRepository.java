package com.sakshi.library_management_system.repository;

import com.sakshi.library_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
