package com.sakshi.library_management_system.service;

import com.sakshi.library_management_system.dto.PublisherDTO;
import com.sakshi.library_management_system.dto.PublisherSaveDTO;
import com.sakshi.library_management_system.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {
    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublisher();

    String UpdatePublisher(PublisherUpdateDTO publisherUpdateDTO);

    String DeletePublisher(int id);
}
