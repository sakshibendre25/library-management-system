package com.sakshi.library_management_system.controller;

import com.sakshi.library_management_system.dto.UserDTO;
import com.sakshi.library_management_system.dto.UserSaveDTO;
import com.sakshi.library_management_system.dto.UserUpdateDTO;
import com.sakshi.library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

       @Autowired
    private UserService userService;

       @PostMapping(path = "/save")
    public  String SaveUser(@RequestBody UserSaveDTO userSaveDTO) {
           String username = userService.addUser(userSaveDTO);
           return "Added Succesfully!!";
       }


       @GetMapping(path = "/getAllUser")
    public List<UserDTO> getAllUser() {
           List<UserDTO> allUsers = userService.getAllUser();
           return  allUsers;
       }

       @PutMapping(path = "/update")
    public String UpdateUser(UserUpdateDTO userUpdateDTO) {
           String username = userService.UpdateUser(userUpdateDTO);
           return username;
       }

       @DeleteMapping(path = "/delete/{id}")
    public String DeleteUser(@PathVariable(value = "id")int id) {
           String username = userService.DeleteUser(id);
           return username;
       }
}
