package com.Secure_Notes_Application.Secure_Notes_Application.repositories;

import com.Secure_Notes_Application.Secure_Notes_Application.models.AppRole;
import com.Secure_Notes_Application.Secure_Notes_Application.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
