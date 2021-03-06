package com.example.bookdatabasecollection.ui.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class AuthorEntity {
    @ColumnInfo
    private String name;

    @ColumnInfo
    private String birthday;

    public AuthorEntity(String name, String birthday){
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
