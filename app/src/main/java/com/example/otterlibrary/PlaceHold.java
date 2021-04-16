package com.example.otterlibrary;
/*
    Title: PlaceHold.java
    Abstract: An activity to create a hold on a book.
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.security.spec.ECField;
import java.util.List;

public class PlaceHold extends AppCompatActivity {
    private static final String TAG = "PlaceHold";

    private otterLibraryDb Otterdb;

    private Spinner genreSpinner;


    private String selectedGenre;
    private List<Book> bookList;

    private ListView bookListView;
    private ArrayAdapter<Book> bookAdapter;
    private Object LayoutInflater;
    private Object ViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_hold);

        Otterdb = otterLibraryDb.getInstance(this);
        genreSpinner = findViewById(R.id.genre_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genre_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genreSpinner.setAdapter(adapter);
        genreSpinner.setSelection(0, false);

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGenre = parent.getItemAtPosition(position).toString();
                Log.d(TAG, selectedGenre);
                bookList = Otterdb.book().findByGenre(selectedGenre);
                Log.d(TAG, bookList.toString());
                bookListView = findViewById(R.id.list_books);
                updateUI(selectedGenre);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void updateUI(String genre){
        bookList = Otterdb.book().findByGenre(genre);

        if(bookAdapter == null ){
            bookAdapter = new ArrayAdapter<>(this, R.layout.item_book, R.id.book_title, bookList);
            bookListView.setAdapter(bookAdapter);
        } else {
            bookAdapter.clear();
            bookAdapter.addAll(bookList);
            bookAdapter.notifyDataSetChanged();
        }
    }

    public void checkoutBox(View view){
        final EditText userName = new EditText(this);
        final EditText passWord = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login");

        final View customLayout = getLayoutInflater().inflate(R.layout.custom_alert, null);
        builder.setView(customLayout);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "ok");
            }
        });

        AlertDialog loginDialog = builder.create();
        loginDialog.show();
    }
}