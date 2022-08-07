package com.ibm.gifgenerator.dto;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "Gifs")
public class Gif {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private int id;
    private String text;
    private Blob gif;

    public Gif() {
    }

    public Gif(int id, String text, Blob gif) {
        this.id = id;
        this.text = text;
        this.gif = gif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Blob getBlob() {
        return gif;
    }

    public void setBlob(Blob gif) {
        this.gif = gif;
    }
}
