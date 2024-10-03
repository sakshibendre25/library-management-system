package com.sakshi.library_management_system.controller;

import com.sakshi.library_management_system.dto.PublisherDTO;
import com.sakshi.library_management_system.dto.PublisherSaveDTO;
import com.sakshi.library_management_system.dto.PublisherUpdateDTO;
import com.sakshi.library_management_system.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;


    @PostMapping(path = "/save")
    public String  savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO) {
        String publishername = publisherService.addPublisher(publisherSaveDTO);
        return "Added Successfully";

    }

    @GetMapping(path = "/getAllPublisher")
    List<PublisherDTO> getAllPublishers() {
        List<PublisherDTO> allPublishers = publisherService.getAllPublisher();
        return allPublishers;
    }

    @PutMapping(path = "/update")
    public String updatePublisher(@RequestBody PublisherUpdateDTO publisherUpdateDTO) {
        String publishername = publisherService.UpdatePublisher(publisherUpdateDTO);
        return  publishername;
    }

    @DeleteMapping(path = "/delete/{id}")
    public  String DeletePublisher(@PathVariable(value = "id") int id) {
        String publishername = publisherService.DeletePublisher(id);
        return "Deleted Successfully!!!";
    }

}
