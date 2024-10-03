package com.sakshi.library_management_system.service;

import com.sakshi.library_management_system.dto.BorrowDTO;
import com.sakshi.library_management_system.dto.BorrowSaveDTO;
import com.sakshi.library_management_system.dto.BorrowUpdateDTO;

import java.util.List;

public interface BorrowService {
    String addBorrow(BorrowSaveDTO borrowSaveDTO);

    List<BorrowDTO> getAllBorrow();

    String updateBorrow(BorrowUpdateDTO borrowUpdateDTO);
}
