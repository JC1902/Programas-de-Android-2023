package jc.dic.nav.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class Tarjeta extends AppCompatActivity {

    VideoView tarjeta;

    String ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);

        tarjeta = findViewById( R.id.tarjeta );

        ruta = "android.resource://" + this.getPackageName() + "/" + R.raw.tarjeta;

        tarjeta.setVideoURI( Uri.parse( ruta ) );

        tarjeta.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping( true );
                tarjeta.requestFocus();
                tarjeta.start();
            }
        });
    }
}