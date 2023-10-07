package ru.nkashlev.notes.controllers.mapping;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nkashlev.notes.model.NoteDTO;
import ru.nkashlev.notes.service.NoteService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @SneakyThrows
    @GetMapping()
    public String start(Model model) {
        model.addAttribute("note", noteService.getNoteById(1L));
        return "/note";
    }
    @SneakyThrows
    @GetMapping("/{id}")
    public String getNote(@PathVariable("id") Long id, Model model) {
        NoteDTO note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "/note";
    }

    @GetMapping("/show")
    public String getAll(Model model) {
        model.addAttribute("notes", noteService.getListNotes());
        return "/show";
    }

    @GetMapping("/new")
    public String newNote(@ModelAttribute("note") NoteDTO note) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("note") NoteDTO note) {
        noteService.createNewNote(note);
        return "redirect:/notes";
    }

    @SneakyThrows
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "/edit";
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public String update(@ModelAttribute("note") NoteDTO note, @PathVariable("id")  Long id) {
        noteService.updateNote(id, note);
        return "redirect:/notes";
    }

    @SneakyThrows
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/notes";
    }
}
