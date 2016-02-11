package com.service;


import com.domain.Note;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pasha on 02.02.2016.
 */
@Service("noteService")
@Transactional
public class NoteService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Note> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Note");
        return query.list();
    }

    public List<Note> getAllDone() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Note as note where note.isDone = TRUE");
        return query.list();
    }
    public List<Note> getAllUndone() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Note as note where note.isDone = FALSE");
       return query.list();
    }
    public Note get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Note note = (Note) session.get(Note.class, id);
        return note;
    }

    public void add(Note note){
        Session session = sessionFactory.getCurrentSession();
        note.setDone(false);
        session.save(note);
    }

    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Note note = (Note) session.get(Note.class, id);
        session.delete(note);
    }

    public void makeDone(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Note note = (Note) session.get(Note.class, id);
        note.setDone(true);
        session.save(note);
    }public void makeUndone(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Note note = (Note) session.get(Note.class, id);
        note.setDone(false);
        session.save(note);
    }
    public void edit(Note note) {
        Session session = sessionFactory.getCurrentSession();
        Note newNote = (Note) session.get(Note.class, note.getId());
        newNote.setText(note.getText());
        session.save(newNote);
    }
}
