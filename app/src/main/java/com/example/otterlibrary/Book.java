package com.example.otterlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int mBookId;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "author")
    private String mAuthor;

    @ColumnInfo(name = "genre")
    private String mGenre;

    public Book(String title, String author, String genre){
        mTitle = title;
        mAuthor = author;
        mGenre = genre;
    }

    public int getBookId() {
        return mBookId;
    }

    public void setBookId(int bookId) {
        mBookId = bookId;
    }

    public String getTitle(){
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public void setAuthor(String author){
        mAuthor =  author;
    }

    public String getGenre(){
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }
}
