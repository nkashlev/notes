package ru.nkashlev.notes.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.UpdateNoteApi;
import ru.nkashlev.notes.model.NoteRequestDTO;
import ru.nkashlev.notes.service.UpdateNoteService;

@RequiredArgsConstructor
@RestController
public class UpdateNoteController implements UpdateNoteApi {

    private final UpdateNoteService updateNoteService;

    @SneakyThrows
    @Override
    public ResponseEntity<Void> updateNote( @PathVariable("note_id") Long noteId, @RequestBody NoteRequestDTO noteRequestDTO) {
        updateNoteService.updateNote(noteId, noteRequestDTO);
        return ResponseEntity.ok().build();
    }
}
