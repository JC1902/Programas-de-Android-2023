package jc.dic.nav.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    String ruta;
    VideoView puchalePlay;
    ImageButton regalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regalo = findViewById( R.id.btnRegalo );
        puchalePlay = findViewById( R.id.puchalePlay );

        regalo.setVisibility( View.INVISIBLE );

        ruta = "android.resource://" + this.getPackageName() + "/" + R.raw.puchale_play;

        puchalePlay.setVideoURI( Uri.parse( ruta ) );

        findViewById(android.R.id.content).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                puchalePlay.setVisibility( View.VISIBLE );

                puchalePlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping( false );
                        puchalePlay.requestFocus();
                        puchalePlay.start();
                    }
                });

                return false;
            }
        });

        puchalePlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                regalo.setVisibility( View.VISIBLE );
                                animateButtonAppearance( regalo );
                            }
                        },
                        500 // Delay de 2 segundos para simular un cambio en setEnabled
                );
            }
        });
    }

    public void irARegalo (View v) {
        Intent intent = new Intent( MainActivity.this, Tarjeta.class );
        startActivity( intent );
    }

    // Método para animar la apariencia del botón
    private void animateButtonAppearance(ImageButton button) {
        // Si el botón está deshabilitado, hacerlo invisible con una animación
        button.animate().alpha(1.0f).setDuration(500).start();
    }
}