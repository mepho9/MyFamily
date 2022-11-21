package com.example.myfamilyback.repository;

import com.example.myfamilyback.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
