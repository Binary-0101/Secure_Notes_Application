package com.Secure_Notes_Application.Secure_Notes_Application.services.impl;

import com.Secure_Notes_Application.Secure_Notes_Application.DTO.UserDTO;
import com.Secure_Notes_Application.Secure_Notes_Application.models.AppRole;
import com.Secure_Notes_Application.Secure_Notes_Application.models.Role;
import com.Secure_Notes_Application.Secure_Notes_Application.models.User;
import com.Secure_Notes_Application.Secure_Notes_Application.repositories.RoleRepository;
import com.Secure_Notes_Application.Secure_Notes_Application.repositories.UserRepository;
import com.Secure_Notes_Application.Secure_Notes_Application.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole)
                .orElseThrow(() -> new RuntimeException("Role is not found"));
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return convertToDTO(user);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.isAccountNonLocked(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCredentialsExpiryDate(),
                user.getAccountExpiryDate(),
                user.getTwoFactorSecret(),
                user.isTwoFactorEnabled(),
                user.getSignUpMethod(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }
}
