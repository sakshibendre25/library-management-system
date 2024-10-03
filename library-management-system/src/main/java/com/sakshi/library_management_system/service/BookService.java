package com.sakshi.library_management_system.service;

import com.sakshi.library_management_system.dto.BookDTO;
import com.sakshi.library_management_system.dto.BookSaveDTO;
import com.sakshi.library_management_system.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String AddBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBook();

    String UpdateBook(BookUpdateDTO bookUpdateDTO);

    String DeleteBook(int id);
}
