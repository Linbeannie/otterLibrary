package com.example.otterlibrary;
 /*
    Title: CreateAccount.java
    Abstract: A class to create a transaction table
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int transactionId;


    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}