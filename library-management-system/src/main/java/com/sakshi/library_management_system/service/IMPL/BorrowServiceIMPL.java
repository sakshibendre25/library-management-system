package com.sakshi.library_management_system.service.IMPL;

import com.sakshi.library_management_system.dto.BorrowDTO;
import com.sakshi.library_management_system.dto.BorrowSaveDTO;
import com.sakshi.library_management_system.dto.BorrowUpdateDTO;
import com.sakshi.library_management_system.entity.Borrow;
import com.sakshi.library_management_system.repository.BookRepository;
import com.sakshi.library_management_system.repository.BorrowRepository;
import com.sakshi.library_management_system.repository.UserRepository;
import com.sakshi.library_management_system.service.BookService;
import com.sakshi.library_management_system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {


    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addBorrow(BorrowSaveDTO borrowSaveDTO) {

        Borrow  borrow = new Borrow(

                bookRepository.getById(borrowSaveDTO.getBook_id()),
                userRepository.getById(borrowSaveDTO.getUser_id()),
                borrowSaveDTO.getBorrowDate(),
                borrowSaveDTO.getReturnDate()


        );

        borrowRepository.save(borrow);


        return "null";
    }

    @Override
    public List<BorrowDTO> getAllBorrow() {

        List<Borrow> getBorrows = borrowRepository.findAll();
        List<BorrowDTO> borrowDTOList = new ArrayList<>();

        for(Borrow borrow:getBorrows){

            BorrowDTO borrowDTO = new BorrowDTO(
                    borrow.getId(),
                    borrow.getBook(),
                    borrow.getUser(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            );
            borrowDTOList.add(borrowDTO);

        }

        return borrowDTOList;


    }

    @Override
    public String updateBorrow(BorrowUpdateDTO borrowUpdateDTO) {

        if(borrowRepository.existsById(borrowUpdateDTO.getId())) {
            Borrow borrow = borrowRepository.getById(borrowUpdateDTO.getId());
            borrow.setBook(bookRepository.getById(borrowUpdateDTO.getBook_id()));
            borrow.setUser(userRepository.getById(borrowUpdateDTO.getUser_id()));
            borrow.setBorrowDate(borrowUpdateDTO.getBorrowDate());
            borrow.setReturnDate(borrowUpdateDTO.getReturnDate());
            borrowRepository.save(borrow);
            return "Borrow updated successfully!!";
        }
        else
        {
            System.out.println("Borrow ID Not Found");
        }

        return "null";



    }
}
