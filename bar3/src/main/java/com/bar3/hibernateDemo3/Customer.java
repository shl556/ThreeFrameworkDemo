package com.bar3.hibernateDemo3;

import java.io.Serializable;
import java.sql.Blob;

public class Customer implements Serializable {
    private Long id;
    private String name;
    private Blob image;

    public Customer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Blob getImage() {
        return this.image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

}

