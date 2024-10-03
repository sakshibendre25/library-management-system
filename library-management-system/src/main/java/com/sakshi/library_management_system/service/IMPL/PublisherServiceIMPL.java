package com.sakshi.library_management_system.service.IMPL;

import com.sakshi.library_management_system.dto.PublisherDTO;
import com.sakshi.library_management_system.dto.PublisherSaveDTO;
import com.sakshi.library_management_system.dto.PublisherUpdateDTO;
import com.sakshi.library_management_system.entity.Publisher;
import com.sakshi.library_management_system.repository.PublisherRepository;
import com.sakshi.library_management_system.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {

        Publisher publisher = new Publisher(
                publisherSaveDTO.getName()
        );

        publisherRepository.save(publisher);
        return publisher.getName();
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {

        List<Publisher> getPublishers = publisherRepository.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();

        for(Publisher publisher:getPublishers) {

            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherid(),
                    publisher.getName()
            );
                publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;


    }

    @Override
    public String UpdatePublisher(PublisherUpdateDTO publisherUpdateDTO) {

        if(publisherRepository.existsById(publisherUpdateDTO.getPublisherid())) {

            Publisher publisher = publisherRepository.getById(publisherUpdateDTO.getPublisherid());
            publisher.setName(publisherUpdateDTO.getName());

            publisherRepository.save(publisher);
            return publisher.getName();


        }
        else
        {
            System.out.println("Publisher ID Not Found");
        }


        return "null";
    }

    @Override
    public String DeletePublisher(int id) {

        if(publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
        }
        else
        {
            System.out.println("Publisher ID Not Found");
        }


        return "null";
    }
}
