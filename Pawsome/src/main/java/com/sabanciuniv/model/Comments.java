package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;

public class Comments {
	@Id private String id;
    private String petId;
    private String text, name;

    public Comments() {
    }

    public Comments(String petId, String text, String name) {
        this.petId = petId;
        this.text = text;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
