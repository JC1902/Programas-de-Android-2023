package mx.edu.itl.c85360673.u4reproaudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button btnFiesta;
    private MediaPlayer audio;
    private GifImageView gifDisco;
    private GifDrawable movGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifDisco = findViewById( R.id.gifDisco );
        audio = MediaPlayer.create( this, R.raw.audio );

        btnFiesta = findViewById ( R.id.btnFiesta );

        btnFiesta.setOnTouchListener( this );
        setVolumeControlStream( AudioManager.STREAM_MUSIC );

        try {
            movGif = new GifDrawable( getResources(), R.drawable.disco );
            gifDisco.setImageDrawable( movGif );
            movGif.stop();
        } catch ( Exception e ) {
            Toast.makeText( this,
                    "Gif no pudo ser cargado, porfavor reinicie la app",
                    Toast.LENGTH_LONG ).show();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent ev) {
        if ( v.getId() == R.id.btnFiesta ) {
            switch ( ev.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    reproducirAudio();
                    break;
                case MotionEvent.ACTION_UP:
                    detenerAudio();
                    break;
            }

            return true;
        }

        return false;
    }

    public void reproducirAudio () {
        if ( audio == null ) {
            audio = MediaPlayer.create( this, R.raw.audio );
            audio.start();

            // Iniciar la animación del GIF si no se ha iniciado.
            if (movGif != null && !movGif.isRunning()) {
                movGif.start();
            }
        } else {
            audio.start();
        }
    }

    public void detenerAudio () {
        if ( audio != null ) {
            audio.stop();
            audio = null;
        }

        // Detener la animación del GIF.
        if (movGif != null && movGif.isRunning()) {
            movGif.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if ( audio != null ) {
            audio = null;
        }
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent( this, AcercaDeActivity.class );
        startActivity( intent );
    }
}