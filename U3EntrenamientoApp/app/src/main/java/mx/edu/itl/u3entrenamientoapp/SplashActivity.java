/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                            Clase Pantalla de carga
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 21/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase del acerca de cuyo único método es para eliminar el activity de
                  la pila y regresar al activity de la calculadora
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  29/Oct/23   Jorge Cisneros       Se agregaron los cambios necesarios para permiitr la
                                     animación del GIF
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3entrenamientoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifDrawable;

//--------------------------------------------------------------------------------------------------

public class SplashActivity extends AppCompatActivity {

    GifImageView gifSplash;
    GifDrawable movGif;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        gifSplash = findViewById( R.id.gifCarga );

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( SplashActivity.this, MainActivity.class );
                startActivity ( intent );
                finish();
            }
        }, 3000 );

        // Aqui se hace el intento de cargar la animación del gif
        try {
            movGif = new GifDrawable( getResources(), R.drawable.icono_app );
            gifSplash.setImageDrawable( movGif );
            movGif.start();
        } catch ( Exception e ) {
            Toast.makeText( this,
                    "Gif no pudo ser cargado, porfavor reinicie la app",
                    Toast.LENGTH_LONG );
        }
    }

    //----------------------------------------------------------------------------------------------

}