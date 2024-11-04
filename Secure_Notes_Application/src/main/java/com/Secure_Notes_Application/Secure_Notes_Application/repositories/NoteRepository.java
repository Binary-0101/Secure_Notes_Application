package com.Secure_Notes_Application.Secure_Notes_Application.repositories;

import com.Secure_Notes_Application.Secure_Notes_Application.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByOwnerUsername(String ownerUsername);
}
