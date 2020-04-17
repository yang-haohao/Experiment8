package com.example.homework8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_main);

        videoView=(VideoView)findViewById(R.id.video);
        mController = new MediaController(this);

        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.INTERNET},0X123);
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]permissions,@NonNull int[] grantResults){
        if(requestCode==0x123&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.d("MainActivity","Ok");
            Log.d("MainActivity","Ok");
            File videoFile=new File(getExternalFilesDir("").toString()+"/test3.MP4");
            if(videoFile.exists()){
                videoView.setVideoPath(videoFile.getPath());
                mController.setMediaPlayer(videoView);
                videoView.setMediaController(mController);
                videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        return false;
                    }
                });
                videoView.requestFocus();
            }
        }
    }
}
