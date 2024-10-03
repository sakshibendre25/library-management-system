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
public class BorrowUpdateDTO {

   private int id;

    private int book_id;

    private int user_id;

    private LocalDate borrowDate;

    private LocalDate returnDate;
}
