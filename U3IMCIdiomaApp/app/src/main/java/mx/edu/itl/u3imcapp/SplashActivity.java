/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                               Clase del Splash
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 06/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase que usa la clase Handler para tener una pantalla de inicio, con
                  el método postDelayed usamos Runnable para determinar la acción y le dimos
                  un tiempo para que al llegar a ese punto realice esa acción.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hacer la transisión al MainActivity después de 2 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear el Intent para llamaer el MainActivity
                Intent intent = new Intent( SplashActivity.this, MainActivity.class );
                startActivity ( intent );
                finish ();
            }
        }, 2000 );

    }
}