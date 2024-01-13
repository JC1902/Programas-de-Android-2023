/*-- =======================================================================================
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*            App de notas que permite marcar si ya se termino la actividad
:*
:*  Archivo     : Acerca_de_activity.java
:*  Autor       : Carlos Fernando Aguilera Garcia     (20130811)
:*  Fecha       : 29/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripci�n : Activiry que muestra informacion acerce de la persona que desarrollo la app

:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*=========================================================================================*/
package mx.edu.itl.c85360673.u4tomarfotosapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_acerca_de );
    }

    public void btnRegresarClick ( View v ) {
            finish ();
    }

}