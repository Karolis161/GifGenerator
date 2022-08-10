package com.ibm.gifgenerator.dto;

import javax.persistence.*;

@Entity
@Table(name = "Gifs")
public class Gif {

    @Id
    @SequenceGenerator(
            name = "gif_sequence",
            sequenceName = "gif_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gif_sequence"
    )

    private int id;
    private String text;
    private String gifUrl;

    public Gif() {
    }

    public Gif(int id, String text, String gifUrl) {
        this.id = id;
        this.text = text;
        this.gifUrl = gifUrl;
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

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }
}
