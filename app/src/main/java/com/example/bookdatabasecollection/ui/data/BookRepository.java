package com.example.bookdatabasecollection.ui.data;

import android.app.Application;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import com.example.bookdatabasecollection.ui.data.dao.BookDao;
import com.example.bookdatabasecollection.ui.data.database.Database;
import com.example.bookdatabasecollection.ui.data.entities.BookEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class BookRepository {

    private BookDao mBookDao;
    private LiveData<List<BookEntity>> mBookList;

    private final Executor mExecutor;

    public BookRepository(Application application, ExecutorService executor){
        Database database = Database.getDatabase(application);
        mExecutor = executor;
        mBookDao = database.bookDao();
        mBookList = mBookDao.getBooks();
    }

    public LiveData<List<BookEntity>> getAllBooks(){return mBookList;}

    public void addBook(BookEntity bookEntity){
        mExecutor.execute(() -> mBookDao.insertBook(bookEntity));
    }
}
