package ru.nkashlev.notes.controllers.rest;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.UpdateNoteApi;
import ru.nkashlev.notes.model.NoteDTO;
import ru.nkashlev.notes.service.NoteService;

@RequiredArgsConstructor
@RestController
public class UpdateNoteController implements UpdateNoteApi {

    private final NoteService noteService;

    @SneakyThrows
    @Override
    public ResponseEntity<Void> updateNote( @PathVariable("note_id") Long noteId, @RequestBody NoteDTO noteRequestDTO) {
        noteService.updateNote(noteId, noteRequestDTO);
        return ResponseEntity.ok().build();
    }
}
