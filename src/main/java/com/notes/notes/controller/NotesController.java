package com.notes.notes.controller;

import com.notes.notes.models.Notes;
import com.notes.notes.repositories.NotesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NotesRepository repository;

    @Autowired
    public NotesController(NotesRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Notes> getAllNotes() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Notes getNoteById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void modifyNoteById(@PathVariable("id") ObjectId id, @Valid @RequestBody Notes notes) {
        notes.set_id(id);
        repository.save(notes);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Notes createNote(@Valid @RequestBody Notes notes) {
        notes.set_id(ObjectId.get());
        repository.save(notes);
        return notes;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}