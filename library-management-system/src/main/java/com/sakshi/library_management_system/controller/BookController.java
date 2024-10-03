package com.sakshi.library_management_system.controller;

import com.sakshi.library_management_system.dto.BookDTO;
import com.sakshi.library_management_system.dto.BookSaveDTO;
import com.sakshi.library_management_system.dto.BookUpdateDTO;
import com.sakshi.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/book")
public class BookController {


    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        String booktitle = bookService.AddBook(bookSaveDTO);
        return "Added Succesfully!!";
    }

    @GetMapping(path = "/getAllBook")
    public List<BookDTO> getAllBooks() {
        List<BookDTO> allBooks =  bookService.getAllBook();
        return allBooks;
    }

    @PutMapping(path = "/update")
    public String UpdateBook(BookUpdateDTO bookUpdateDTO) {
        String bookTitle = bookService.UpdateBook(bookUpdateDTO);
        return bookTitle;
    }

    @DeleteMapping(path = "delete/{id}")
    public String DeleteBook(@PathVariable(value = "id") int id) {
        String bookTitle = bookService.DeleteBook(id);
        return "Deleted Successfully!!!";
    }


}
