package ru.nkashlev.notes.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.CreateNoteApi;
import ru.nkashlev.notes.model.NoteDTO;
import ru.nkashlev.notes.service.NoteService;


@RequiredArgsConstructor
@RestController
public class CreateNoteController implements CreateNoteApi {

    private final NoteService noteService;

    @Override
    public ResponseEntity<Void> createNote(@RequestBody NoteDTO noteRequestDTO) {
        noteService.createNewNote(noteRequestDTO);
        return ResponseEntity.ok().build();
    }
}


