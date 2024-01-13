package mx.edu.itl2018b.a85360673.u4reproduccionvideoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    String ruta;
    VideoView video;

    ProgressDialog carga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        carga = new ProgressDialog( this );
        carga.setCanceledOnTouchOutside( false );
        carga.show();
        carga.setContentView( R.layout.progressdialog_personal );

        video = findViewById( R.id.vvVideo );

        ruta = getIntent().getStringExtra( "rutaVideo" );

        video.setVideoURI( Uri.parse( ruta ) );
        video.setMediaController( new MediaController( this ) );

        video.setOnPreparedListener( new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared( MediaPlayer mediaPlayer ) {
                mediaPlayer.setLooping( false );
                video.requestFocus();
                carga.dismiss();
                video.start();
            }
        });

        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish ();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt( "position", video.getCurrentPosition() );
        video.pause();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int posicion = savedInstanceState.getInt( "position" );

        video.seekTo( posicion );
    }
}