package com.example.bookdatabasecollection.ui.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bookdatabasecollection.ui.data.entities.BookEntity;

import java.util.List;

@Dao
public abstract class BookDao {

    @Query("SELECT * FROM books")
    public abstract LiveData<List<BookEntity>> getBooks();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insertBook(BookEntity book);

    @Query("DELETE FROM books")
    public abstract void deleteBooks();
}
