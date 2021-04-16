package com.example.otterlibrary;
/*
    Title: otterLibraryDb.java
    Abstract: Creates and adds to the database.
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.GregorianCalendar;

@Database(entities = {User.class, Book.class, Transaction.class}, version = 1, exportSchema = false)
public abstract class otterLibraryDb extends RoomDatabase {


    private static otterLibraryDb sInstance;
    public abstract UserDao userDao();
    public abstract  BookDao book();
    public abstract TransactionDao transaction();

    public static synchronized otterLibraryDb getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    otterLibraryDb.class,
                    "otterlib.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }


    public void seed() {
        if (userDao().count() == 0 && book().count() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    userDao().insertUsers(
                      new User("a@lice5", "@csit100"),
                      new User("$brian7", "123abc##"),
                      new User("!chris12!", "CHRIS12!!")
                    );
                    book().insertBook(
                      new Book("I Know Why the Caged Bird Sings", "Maya Angelou", "Memoir"),
                      new Book("The Mythical Man-Month", "Frederick Brooks", "Computer Science"),
                      new Book("Frankenstein", "Mary Shelley", "Fiction")
                    );
                }
            });
        }
    }
}