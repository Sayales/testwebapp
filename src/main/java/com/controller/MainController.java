package com.controller;
;
import com.domain.Note;
import com.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ����� on 15.01.2016.
 */



@Controller
@RequestMapping("/")
public class MainController {

    @Resource(name = "noteService")
    private NoteService noteService;

    @RequestMapping(value = "/add-note", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("note") Note note){
        noteService.add(note);
        List<Note> notes = noteService.getAll();
        ModelAndView model = new ModelAndView("allnotes","notes", notes);
        return model;
    }
    @RequestMapping(value = "/add-note", method = RequestMethod.GET)
    public ModelAndView getUser() {
        return new ModelAndView("addnote", "note", new Note());
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {

        return new ModelAndView("hello");
    }
    @RequestMapping(value = "/allnote", method = RequestMethod.GET)
    public String getNotes(Model model) {
       List<Note> notes = noteService.getAll();
        model.addAttribute("notes", notes);
        return "allnotes";
    }
    @RequestMapping(value = "/alldone", method = RequestMethod.GET)
    public String getDoneNotes(Model model) {
        List<Note> notes = noteService.getAllDone();
        model.addAttribute("notes", notes);
        return "allnotes";
    }
    @RequestMapping(value = "/allundone", method = RequestMethod.GET)
    public String getUndoneNotes(Model model) {
        List<Note> notes = noteService.getAllUndone();
        model.addAttribute("notes", notes);
        return "allnotes";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(value = "id", required = true) Integer id,Model model) {
        noteService.delete(id);
       return new ModelAndView("allnotes", "notes", noteService.getAll());
    }
    @RequestMapping(value = "/makedone", method = RequestMethod.GET)
    public String makeDone(@RequestParam(value = "id", required = true) Integer id, Model model) {
        noteService.makeDone(id);
        List<Note> notes = noteService.getAll();
        model.addAttribute("notes", notes);
        return "allnotes";
    }
    @RequestMapping(value = "/makeundone", method = RequestMethod.GET)
    public String makeUnone(@RequestParam(value = "id", required = true) Integer id, Model model) {
        noteService.makeUndone(id);
        List<Note> notes = noteService.getAll();
        model.addAttribute("notes", notes);
        return "allnotes";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editNote(@RequestParam(value = "id", required = true) Integer id) {
        return new ModelAndView("editnote", "note", noteService.get(id));
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editedNote(@ModelAttribute("note") Note note, @RequestParam(value = "id", required = true) Integer id) {
        note.setId(id);
        noteService.edit(note);
        return new ModelAndView("allnotes", "notes", noteService.getAll());
    }
}

