package ru.nkashlev.notes.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.nkashlev.notes.entity.Note;
import ru.nkashlev.notes.exceptions.ResourceNotFoundException;
import ru.nkashlev.notes.model.NoteDTO;
import ru.nkashlev.notes.model.StyleText;
import ru.nkashlev.notes.repositories.NoteRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(NoteService.class);


    @PostConstruct
    public void initialize() {
        if (noteRepository.count() == 0) {
            Note note = new Note();
            note.setTitle("Title");
            note.setContent("Content");
            StyleText styleText = new StyleText();
            styleText.setItalics(true);
            styleText.setBold(false);
            styleText.setFont("Arial");
            styleText.setTextSize(12);
            note.setStyleText(styleText);
            noteRepository.save(note);
            LOGGER.info("New note created with title: {}", note.getTitle());
        }
    }

    public Long createNewNote(NoteDTO request) {
        Note note = saveNote(request);
        LOGGER.info("New note created with title: {}", request.getTitle());
        return note.getNoteId();
    }

    public void updateNote(Long noteId, NoteDTO request) {
        saveNote(request);
        LOGGER.info("Note updated with id: {}", noteId);
    }

    public NoteDTO getNoteById(Long noteId) throws ResourceNotFoundException {
        Note note = findNoteById(noteId);
        return new NoteDTO()
                .noteId(note.getNoteId())
                .title(note.getTitle())
                .content(note.getContent());
    }

    public void deleteNoteById(Long noteId) throws ResourceNotFoundException {
        Note note = findNoteById(noteId);
        noteRepository.delete(note);
        LOGGER.info("Note deleted with id: {}", noteId);
    }

    public List<NoteDTO> getListNotes() {
        Iterable<Note> iterable = noteRepository.findAll();

        ArrayList<NoteDTO> notes = new ArrayList<>();
        for (Note note : iterable) {
            notes.add(new NoteDTO()
                    .noteId(note.getNoteId())
                    .title(note.getTitle())
                    .content(note.getContent()));
        }
        LOGGER.info("Notes returned: {}", notes);
        return notes;
    }

    private Note saveNote(NoteDTO request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        StyleText styleText = new StyleText();
        styleText.setItalics(request.getStyleText().isItalics());
        styleText.setBold(request.getStyleText().isBold());
        styleText.setFont(request.getStyleText().getFont());
        styleText.setTextSize(request.getStyleText().getTextSize());
        note.setStyleText(styleText);
        noteRepository.save(note);
        LOGGER.info("New note saved with id: {}", request.getNoteId());
        return note;
    }

    private Note findNoteById(Long id) throws ResourceNotFoundException {
        LOGGER.info("Started to find note with id: {}", id);
        Note note = noteRepository.findById(id).orElse(null);
        if (note == null) {
            throw new ResourceNotFoundException("Cannot find note with id: " + id);
        }
        LOGGER.info("Found note with id: {}", id);
        return note;
    }

}

