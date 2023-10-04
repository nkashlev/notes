package ru.nkashlev.notes.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.nkashlev.notes.entity.Note;
import ru.nkashlev.notes.exceptions.ResourceNotFoundException;
import ru.nkashlev.notes.model.NoteRequestDTO;
import ru.nkashlev.notes.repositories.NoteRepository;
@RequiredArgsConstructor
@Service
public class UpdateNoteService {
    private final NoteRepository noteRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(UpdateNoteService.class);

    public void updateNote(Long noteId, NoteRequestDTO request) throws ResourceNotFoundException {
        Note note = findNoteById(noteId);
        note.setNoteId(request.getNoteId());
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        noteRepository.save(note);
        LOGGER.info("Note updated with title: {}", request.getTitle());
    }

    public Note findNoteById(Long id) throws ResourceNotFoundException {
        LOGGER.info("Started to find note with id: {}", id);
        Note note = noteRepository.findById(id).orElse(null);
        if (note == null) {
            throw new ResourceNotFoundException("Cannot find note with id: {}"+ id);
        }
        LOGGER.info("Found note with id: {}", id);
        return note;
    }
}
