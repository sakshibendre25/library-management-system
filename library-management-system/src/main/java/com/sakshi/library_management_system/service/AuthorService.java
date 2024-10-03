package com.sakshi.library_management_system.service;

import com.sakshi.library_management_system.dto.AuthorDTO;
import com.sakshi.library_management_system.dto.AuthorSaveDTO;
import com.sakshi.library_management_system.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {


    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<AuthorDTO> getAllAuthor();

    String UpdateAuthor(AuthorUpdateDTO authorUpdateDTO);

    String DeleteAuthor(int id);
}
