package com.sakshi.library_management_system.dto;

import com.sakshi.library_management_system.entity.Author;
import com.sakshi.library_management_system.entity.Publisher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {


    private  int bookid;

    private String title;

    private Author author;

    private Publisher publisher;
}
