package com.example.otterlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;
/*
    Title: MainActivity.java
    Abstract: An activity to go to Create Account, Place Hold or Manage System
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private otterLibraryDb db;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = otterLibraryDb.getInstance(getApplicationContext());
        db.seed();

        Button createAcc = findViewById(R.id.createAcc);
        createAcc.setOnClickListener(this);

        Button hold = findViewById(R.id.hold);
        hold.setOnClickListener(this);

        Button manage = findViewById(R.id.manage);
        manage.setOnClickListener(this);

    }
    public void onClick(View v){
        Intent myAccountIntent = new Intent(this, CreateAccount.class);
        Intent myHoldIntent = new Intent(this, PlaceHold.class);
        Intent myManageIntent = new Intent(this, ManageSystem.class);
        if(v.getId() == R.id.createAcc){

            MainActivity.this.startActivity(myAccountIntent);
        }
        else if(v.getId() == R.id.hold){
            MainActivity.this.startActivity(myHoldIntent);
        }
        else{
            MainActivity.this.startActivity(myManageIntent);
        }
    }
}