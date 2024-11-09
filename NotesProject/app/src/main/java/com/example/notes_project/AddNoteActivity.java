package com.example.notes_project;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private EditText noteTitleInput, noteContentInput;
    private Spinner categorySpinner;
    private Button saveNoteButton;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        // Initialize views
        noteTitleInput = findViewById(R.id.noteTitleInput);
        noteContentInput = findViewById(R.id.noteContentInput);
        categorySpinner = findViewById(R.id.categorySpinner);
        saveNoteButton = findViewById(R.id.saveNoteButton);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Set click listener for save button
        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        String title = noteTitleInput.getText().toString().trim();
        String content = noteContentInput.getText().toString().trim();
        String category = categorySpinner.getSelectedItem().toString();

        // Check for empty fields
        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(AddNoteActivity.this, "Please fill out both the title and content.", Toast.LENGTH_SHORT).show();
        } else {
            // Save the note to SQLite database
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_TITLE, title);
            values.put(DatabaseHelper.COLUMN_CONTENT, content);
            values.put(DatabaseHelper.COLUMN_CATEGORY, category);

            // Insert the note into the database
            long newRowId = db.insert(DatabaseHelper.TABLE_NOTES, null, values);

            if (newRowId != -1) {
                Toast.makeText(AddNoteActivity.this, "Note saved!", Toast.LENGTH_SHORT).show();
                finish(); // Close the AddNoteActivity and return to HomeActivity
            } else {
                Toast.makeText(AddNoteActivity.this, "Error saving note", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
