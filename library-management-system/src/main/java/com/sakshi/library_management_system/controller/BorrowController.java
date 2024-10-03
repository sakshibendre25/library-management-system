package com.sakshi.library_management_system.controller;

import com.sakshi.library_management_system.dto.BorrowDTO;
import com.sakshi.library_management_system.dto.BorrowSaveDTO;
import com.sakshi.library_management_system.dto.BorrowUpdateDTO;
import com.sakshi.library_management_system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/borrow")
public class BorrowController {


    @Autowired
    private BorrowService borrowService;



    @PostMapping(path = "/save")
    public  String saveBorrow(@RequestBody BorrowSaveDTO borrowSaveDTO) {
        String borrowbooks = borrowService.addBorrow(borrowSaveDTO);
        return "Borrowed Successfully!!";
    }

    @GetMapping(path = "/getAllBorrow")
    public List<BorrowDTO> getAllBorrows() {
        List<BorrowDTO> allborrows = borrowService.getAllBorrow();
        return allborrows;
     }

     @PutMapping(path = "/update")
    public String updateBorrow (@RequestBody BorrowUpdateDTO borrowUpdateDTO ) {
        String borrow = borrowService.updateBorrow(borrowUpdateDTO);
        return "updatedd";
     }
}
