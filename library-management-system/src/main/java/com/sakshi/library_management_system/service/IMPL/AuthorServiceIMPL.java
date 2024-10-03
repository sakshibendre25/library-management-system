package com.sakshi.library_management_system.service.IMPL;

import com.sakshi.library_management_system.dto.AuthorDTO;
import com.sakshi.library_management_system.dto.AuthorSaveDTO;
import com.sakshi.library_management_system.dto.AuthorUpdateDTO;
import com.sakshi.library_management_system.entity.Author;
import com.sakshi.library_management_system.repository.AuthorRepository;
import com.sakshi.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {

        Author author = new Author(
                authorSaveDTO.getName()


        );
        authorRepository.save(author);
        return author.getName();


    }

    @Override
    public List<AuthorDTO> getAllAuthor() {

        List<Author> getAuthors = authorRepository.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : getAuthors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorid(),
                    author.getName()
            );

            authorDTOList.add(authorDTO);


        }
        return authorDTOList;
    }

    @Override
    public String UpdateAuthor(AuthorUpdateDTO authorUpdateDTO) {

        if (authorRepository.existsById(authorUpdateDTO.getAuthorid())) {

            Author author = authorRepository.getById(authorUpdateDTO.getAuthorid());
            author.setName(authorUpdateDTO.getName());

            authorRepository.save(author);
            return author.getName();
        } else {
            System.out.println("Author ID Not Found");
        }
        return null;
    }

    @Override
    public String DeleteAuthor(int id) {

        if(authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        }
        else
        {
            System.out.println("Author ID Not Found");
        }

        return "Deleted Succesfully!!";
    }
}









