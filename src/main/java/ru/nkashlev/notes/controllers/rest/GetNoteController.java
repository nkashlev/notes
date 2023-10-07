package ru.nkashlev.notes.controllers.rest;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.GetNoteApi;
import ru.nkashlev.notes.model.NoteDTO;
import ru.nkashlev.notes.service.NoteService;

@RequiredArgsConstructor
@RestController
public class GetNoteController implements GetNoteApi {

    private final NoteService noteService;

    @SneakyThrows
    @Override
    public ResponseEntity<NoteDTO> getNote(@PathVariable("note_id") Long noteId) {
        return ResponseEntity.ok(noteService.getNoteById(noteId));
    }
}
