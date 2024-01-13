/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                     Clase que contiene la segunda bandera
:*
:*  Archivo     : Bandera2Activity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 12/Sept/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : La clase contiene la segunda bandera y el método
                  para pasar a la siguiente y a la anterior a esta.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:* 14/Sept      Jorge Cisneros       Se agregaron los métodos relacionados con el ciclo de
                                     vide de un activity y que se muestren en la app.
:*------------------------------------------------------------------------------------------*/

package com.example.u2band3lay3actapp;

    //----------------------------------------------------------------------------------------------

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

    //----------------------------------------------------------------------------------------------

public class Bandera2Activity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.bandera2_layout );
        mostrarToast( "[Bandera2] onCreate");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onStart () {
        super.onStart();
        mostrarToast( "[Bandera2] onStart");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onResume () {
        super.onResume();
        mostrarToast( "[Bandera2] onResume");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onRestart () {
        super.onRestart();
        mostrarToast( "[Bandera2] onRestart");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onPause() {
        super.onPause();
        mostrarToast( "[Bandera2] onPause");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onStop() {
        super.onStop();
        mostrarToast( "[Bandera2] onStop");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostrarToast( "[Bandera2] onDestroy");
    }

    //----------------------------------------------------------------------------------------------

    public void btnAccionClick ( View v ) {
        if ( v.getId() == R.id.btnBand2Atras ) {
            finish (); // Terminar este activity
        } else if ( v.getId() == R.id.btnBand2Siguiente ) {
            // Invocar al activity de la bandera 3
            Intent intent = new Intent ( this, Bandera3Activity.class );
            startActivity ( intent );
        }
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarToast ( CharSequence mensaje ) {
        Toast.makeText( this, mensaje, Toast.LENGTH_SHORT ).show();
    }

    //----------------------------------------------------------------------------------------------

}