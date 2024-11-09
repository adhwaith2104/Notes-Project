package com.example.notes_project;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private FloatingActionButton fabAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // This is your home screen layout

        // Initialize the Floating Action Button (FAB)
        fabAddNote = findViewById(R.id.fabAddNote);

        // Set up click listener for FAB to launch AddNoteActivity
        fabAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AddNoteActivity.class);
            startActivity(intent);
        });
    }
}
