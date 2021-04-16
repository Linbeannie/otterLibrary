package com.example.otterlibrary;
/*
    Title: BookDao.java
    Abstract: An interface to add Book database objects.
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {

    @Query("SELECT count(*) from books")
        int count();

    @Insert
    long addBook(Book book);

    @Insert
    long[] insertBook(Book... book);

    @Query("SELECT * FROM books")
    List<Book> getAllBooks();

    @Query("SELECT * FROM books WHERE genre = :genre")
    List<Book> findByGenre(String genre);

    @Query("SELECT * FROM books WHERE title = :title")
    List<Book> findByTitle(String title);
}
