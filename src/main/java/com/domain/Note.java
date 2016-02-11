package com.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pasha on 01.02.2016.
 */
@Entity
@Table(name = "notes")
public class Note implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;


    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DONE")
    private boolean isDone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
