package com.example.bookdatabasecollection.ui.data.entities;

public class Author {
    private String name;
    private String birthday;

    public Author(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
