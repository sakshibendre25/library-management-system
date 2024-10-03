package com.sakshi.library_management_system.service.IMPL;

import com.sakshi.library_management_system.dto.BookDTO;
import com.sakshi.library_management_system.dto.BookSaveDTO;
import com.sakshi.library_management_system.dto.BookUpdateDTO;
import com.sakshi.library_management_system.entity.Book;
import com.sakshi.library_management_system.repository.AuthorRepository;
import com.sakshi.library_management_system.repository.BookRepository;
import com.sakshi.library_management_system.repository.PublisherRepository;
import com.sakshi.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override
    public String AddBook(BookSaveDTO bookSaveDTO) {

        Book book = new Book(
                bookSaveDTO.getTitle(),
                authorRepository.getById(bookSaveDTO.getAuthor_id()),
                publisherRepository.getById(bookSaveDTO.getPublisher_id())


        );

        bookRepository.save(book);
        return book.getTitle();


    }

    @Override
    public List<BookDTO> getAllBook() {

        List<Book> getBooks = bookRepository.findAll(); {
            List<BookDTO> bookDTOList = new ArrayList<>();

            for (Book book : getBooks) {
                BookDTO bookDTO = new BookDTO(
                        book.getBookid(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher()
                );
                bookDTOList.add(bookDTO);
            }
            return bookDTOList;
        }
    }

    @Override
    public String UpdateBook(BookUpdateDTO bookUpdateDTO) {

        if (bookRepository.existsById(bookUpdateDTO.getBookid())) {

            Book book = bookRepository.getById(bookUpdateDTO.getBookid());
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuthor(authorRepository.getById(bookUpdateDTO.getAuthor_id()));
            book.setPublisher(publisherRepository.getById(bookUpdateDTO.getPublisher_id()));
            bookRepository.save(book);
            return book.getTitle();

        } else {
            System.out.println("Book ID Not Found");
        }
        return null;

    }



    @Override
    public String DeleteBook(int id) {

        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        else
        {
            System.out.println("Book ID Not Found");
        }

        return "null";
    }
}



