package com.sakshi.library_management_system.service;

import com.sakshi.library_management_system.dto.UserDTO;
import com.sakshi.library_management_system.dto.UserSaveDTO;
import com.sakshi.library_management_system.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();

    String UpdateUser(UserUpdateDTO userUpdateDTO);

    String DeleteUser(int id);
}
