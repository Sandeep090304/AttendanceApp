package com.example.attendanceapp.FirstScreen;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.attendanceapp.LoginPage;
import com.example.attendanceapp.MainActivity;
import com.example.attendanceapp.R;

public class Splash extends AppCompatActivity {
    VideoView videoView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent= new Intent(Splash.this, LoginPage.class);
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath( "android.resource://" + getPackageName() + "/" + R.raw.front);
        // videoView.setControls(false);
        MediaController mediaController;
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                videoView.start();
                startActivity(intent);
                finish();
            }
        },6300);
    }
}
