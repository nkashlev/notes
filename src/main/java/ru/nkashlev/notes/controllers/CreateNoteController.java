package ru.nkashlev.notes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.CreateNoteApi;
import ru.nkashlev.notes.model.NoteRequestDTO;
import ru.nkashlev.notes.service.CreateNoteService;


@RequiredArgsConstructor
@RestController
public class CreateNoteController implements CreateNoteApi {

    private final CreateNoteService createNoteService;

    @Override
    public ResponseEntity<Void> createNote(@RequestBody NoteRequestDTO noteRequestDTO) {
        createNoteService.createNewNote(noteRequestDTO);
        return ResponseEntity.ok().build();
    }
}


