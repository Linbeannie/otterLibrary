package com.example.otterlibrary;
/*
    Title: User.java
    Abstract: An activity to create User table
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mId;

    @ColumnInfo(name="username")
    private String mUsername;

    @ColumnInfo(name = "password")
    private String mPassword;



    public User(String username, String password) {
       mUsername = username;
       mPassword = password;

    }

    public int getMId() { return mId;}

    public void setMId(int id) { mId = id;}

    public String getUsername() { return mUsername;}

    public void setUsername(String username) { this.mUsername = username ;}

    public String getPassword() {return mPassword;}

    public void setPassword(String password) {this.mPassword = password;}


    @Override
    public String toString() {
        return mUsername + " " + mPassword;
    }
}
