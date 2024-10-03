package com.sakshi.library_management_system.dto;

import com.sakshi.library_management_system.entity.Book;
import com.sakshi.library_management_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowDTO {
private  int id;

    private Book book;

    private User user;

    private LocalDate borrowDate;

    private LocalDate returnDate;

}
