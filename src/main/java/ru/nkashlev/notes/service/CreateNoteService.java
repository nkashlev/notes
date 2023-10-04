package ru.nkashlev.notes.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.nkashlev.notes.entity.Note;
import ru.nkashlev.notes.model.NoteRequestDTO;
import ru.nkashlev.notes.repositories.NoteRepository;

@RequiredArgsConstructor
@Service
public class CreateNoteService {

    private final NoteRepository noteRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(CreateNoteService.class);

    public void createNewNote(NoteRequestDTO request) {
        saveNote(request);
        LOGGER.info("New note created with title: {}", request.getTitle());
    }

    private void saveNote(NoteRequestDTO request) {
        Note note = new Note();
        note.setNoteId(request.getNoteId());
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        noteRepository.save(note);
        LOGGER.info("New note saved with ID: {}", request.getNoteId());
    }
}
