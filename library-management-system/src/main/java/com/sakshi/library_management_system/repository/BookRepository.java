package com.sakshi.library_management_system.repository;

import com.sakshi.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
