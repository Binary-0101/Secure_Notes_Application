package com.Secure_Notes_Application.Secure_Notes_Application.services.interfaces;

import com.Secure_Notes_Application.Secure_Notes_Application.DTO.UserDTO;
import com.Secure_Notes_Application.Secure_Notes_Application.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void updateUserRole(Long userId, String roleName);

    UserDTO getUserById(Long id);
}
