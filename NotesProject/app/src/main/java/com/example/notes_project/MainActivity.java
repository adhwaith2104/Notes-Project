package com.example.notes_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main); // This is your splash screen layout

        // Use a Handler to transition to HomeActivity after a 2-second delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an intent to go to HomeActivity
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

                // Finish MainActivity to prevent going back to it
                finish();
            }
        }, 2000); // 2000 milliseconds delay (2 seconds)
    }
}
