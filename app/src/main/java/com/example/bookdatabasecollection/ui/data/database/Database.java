package com.example.bookdatabasecollection.ui.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bookdatabasecollection.ui.data.dao.BookDao;
import com.example.bookdatabasecollection.ui.data.entities.BookEntity;

@androidx.room.Database(entities = {BookEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public static final String NAME = "DataBase";
    private static Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, Database.NAME).fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract BookDao bookDao();
}
