package ru.nkashlev.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nkashlev.notes.entity.Note;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
