package ru.nkashlev.notes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.GetNotesApi;

import ru.nkashlev.notes.model.NoteDTO;
import ru.nkashlev.notes.service.NoteService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GetListNotesController implements GetNotesApi {
    private final NoteService noteService;

    @Override
    public ResponseEntity<List<NoteDTO>> getNotes() {
        return ResponseEntity.ok(noteService.getListNotes());
    }
}
