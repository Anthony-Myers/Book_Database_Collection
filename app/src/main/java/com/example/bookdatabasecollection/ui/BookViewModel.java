package com.example.bookdatabasecollection.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bookdatabasecollection.ui.data.BookRepository;
import com.example.bookdatabasecollection.ui.data.entities.Author;
import com.example.bookdatabasecollection.ui.data.entities.BookEntity;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private BookRepository mBookRepository;

    private LiveData<List<BookEntity>> mAllBooks;

    public BookViewModel(@NonNull Application application){
        super(application);
        mBookRepository = new BookRepository(application, ((BookApplication)application).getExecutorService());
        mAllBooks = mBookRepository.getAllBooks();
    }

    public LiveData<List<BookEntity>> getListOfBooks(){return mAllBooks;};

    public void populateDataBase(){

        BookEntity book1 = new BookEntity();
        BookEntity book2 = new BookEntity();
        BookEntity book3 = new BookEntity();
        BookEntity book4 = new BookEntity();
        BookEntity book5 = new BookEntity();

        book1.setTitle("The Old Man and the Sea");
        book1.setPublishedDate("09/01/1952");
        book1.setAuthor(new Author("Ernest Hemingway", "07/21/1899"));
        book1.setUrl("https://en.wikipedia.org/wiki/The_Old_Man_and_the_Sea");

        book2.setTitle("To Kill a Mockingbird");
        book2.setPublishedDate("07/11/1960");
        book2.setAuthor(new Author("Harper Lee", "04/28/1926"));
        book2.setUrl("https://en.wikipedia.org/wiki/To_Kill_a_Mockingbird");

        book3.setTitle("The Great Gatsby");
        book3.setPublishedDate("04/10/1925");
        book3.setAuthor(new Author("F. Scott Fitzgerald", "09/24/1896"));
        book3.setUrl("https://en.wikipedia.org/wiki/The_Great_Gatsby");

        book4.setTitle("Nineteen Eighty-Four");
        book4.setPublishedDate("06/08/1949");
        book4.setAuthor(new Author("George Orwell", "06/25/1903"));
        book4.setUrl("https://en.wikipedia.org/wiki/Nineteen_Eighty-Four");

        book5.setTitle("The Catcher in the Rye");
        book5.setPublishedDate("07/16/1951");
        book5.setAuthor(new Author("J. D. Salinger", "01/01/1919"));
        book5.setUrl("https://en.wikipedia.org/wiki/The_Catcher_in_the_Rye");

        mBookRepository.addBook(book1);
        mBookRepository.addBook(book2);
        mBookRepository.addBook(book3);
        mBookRepository.addBook(book4);
        mBookRepository.addBook(book5);
    }
}
