package com.example.attendanceapp.FirstScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.attendanceapp.LoginPage;
import com.example.attendanceapp.R;

public class Splash extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Intent to start LoginPage after the splash screen
        Intent intent = new Intent(Splash.this, LoginPage.class);

        // Initialize VideoView
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.front);

        // Create a MediaController
        MediaController mediaController = new MediaController(this);

        // Set MediaController to hide it
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE); // Hide the MediaController

        // Start the video playback immediately
        videoView.start();

        // Start LoginPage after video playback completes
        videoView.setOnCompletionListener(mp -> {
            startActivity(intent);
            finish();
        });
    }
}
