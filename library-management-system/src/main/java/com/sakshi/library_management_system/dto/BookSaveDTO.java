package com.sakshi.library_management_system.dto;

import com.sakshi.library_management_system.entity.Author;
import com.sakshi.library_management_system.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookSaveDTO {


    private String title;

    private int  author_id;

    private int publisher_id;
}

