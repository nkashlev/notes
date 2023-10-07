package ru.nkashlev.notes.controllers.rest;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.notes.api.DeleteNoteApi;
import ru.nkashlev.notes.service.NoteService;

@RequiredArgsConstructor
@RestController
public class DeleteNoteController implements DeleteNoteApi {

    private final NoteService noteService;
    @SneakyThrows
    @Override
    public ResponseEntity<Void> deleteNote(@PathVariable("note_id") Long noteId) {
        noteService.deleteNoteById(noteId);
        return ResponseEntity.ok().build();
    }
}
