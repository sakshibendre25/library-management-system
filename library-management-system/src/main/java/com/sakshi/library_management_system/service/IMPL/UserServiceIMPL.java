package com.sakshi.library_management_system.service.IMPL;

import com.sakshi.library_management_system.dto.UserDTO;
import com.sakshi.library_management_system.dto.UserSaveDTO;
import com.sakshi.library_management_system.dto.UserUpdateDTO;
import com.sakshi.library_management_system.entity.User;
import com.sakshi.library_management_system.repository.UserRepository;
import com.sakshi.library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public String addUser(UserSaveDTO userSaveDTO) {

        User user = new User(
                userSaveDTO.getName(),
                userSaveDTO.getEmail()
        );
        userRepository.save(user);
        return user.getName();

    }

    @Override
    public List<UserDTO> getAllUser() {

        List<User> getUsers = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : getUsers) {

            UserDTO userDTO = new UserDTO(
                    user.getUserid(),
                    user.getName(),
                    user.getEmail()
            );
            userDTOList.add(userDTO);

        }
        return userDTOList;
    }

    @Override
    public String UpdateUser(UserUpdateDTO userUpdateDTO) {

        if(userRepository.existsById(userUpdateDTO.getUserid())) {
            User user = userRepository.getById(userUpdateDTO.getUserid());
            user.setName(userUpdateDTO.getName());
            user.setEmail(userUpdateDTO.getEmail());
            userRepository.save(user);
            return user.getName();
        }
        else
        {
            System.out.println("User ID Not Found");
        }
        return "null";
    }

    @Override
    public String DeleteUser(int id) {

        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else
        {
            System.out.println("User ID Not Found");
        }

        return "Deleted Succesfully!!";
    }


}
