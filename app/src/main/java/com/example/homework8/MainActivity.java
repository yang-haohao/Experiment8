package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_main);

        videoView=(VideoView)findViewById(R.id.video);
        mController = new MediaController(this);

        String videoPath= Environment.getExternalStorageDirectory().getPath()+"/test2.mp4";
        File video=new File(videoPath);
        if(video.exists()){
            videoView.setVideoPath(video.getAbsolutePath());
            videoView.setMediaController(mController);
            mController.setMediaPlayer(videoView);
            videoView.requestFocus();
        }
    }
}
