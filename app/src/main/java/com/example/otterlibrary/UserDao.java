package com.example.otterlibrary;
/*
    Title: UserDao.java
    Abstract: An interface to add User database objects and queries.
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
    public interface UserDao {

        @Query("select count(*) from users")
        int count();

        @Query("select * from users")
        List<User> getAllUsers();

        @Query("select * from users where username = :userName")
        boolean usernameExists(String userName);

        @Query("select * from users where password = :password")
        User findByPassword(String password);

         @Insert
         long insertUser(User user);

         @Insert
        long[] insertUsers(User... user);
    }

