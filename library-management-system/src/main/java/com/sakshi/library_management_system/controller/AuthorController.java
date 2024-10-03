package com.sakshi.library_management_system.controller;


import com.sakshi.library_management_system.dto.AuthorDTO;
import com.sakshi.library_management_system.dto.AuthorSaveDTO;
import com.sakshi.library_management_system.dto.AuthorUpdateDTO;
import com.sakshi.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @PostMapping(path = "/save")
    public  String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO) {
        String authorname = authorService.addAuthor(authorSaveDTO);
        return "Added Successfully!!";
    }

    @GetMapping(path = "/getAllAuthor")
    public List<AuthorDTO> getAllAuthor() {
        List<AuthorDTO> allauthors = authorService.getAllAuthor();
        return allauthors;
    }

    @PutMapping(path = "/update")
    public String UpdateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO) {
        String  authorname = authorService.UpdateAuthor(authorUpdateDTO);
        return authorname;

    }

    @DeleteMapping(path = "/delete/{id}")
    public String DeleteAuthor(@PathVariable(value = "id") int id) {
        String authorname = authorService.DeleteAuthor(id);
        return authorname;
    }


}
