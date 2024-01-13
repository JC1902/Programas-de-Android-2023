/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                 Clase que muestra la última bandera de la app
:*
:*  Archivo     : Bandera3Activity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 12/Sept/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : En esta clase se muestra la últma bandera de la aplicación
                  y con su respectivo método para regresar a la anteriror.
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

public class Bandera3Activity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.bandera3_layout );
        mostrarToast( "[Bandera3] onCreate");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onStart () {
        super.onStart();
        mostrarToast( "[Bandera3] onStart");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onResume () {
        super.onResume();
        mostrarToast( "[Bandera3] onResume");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onRestart () {
        super.onRestart();
        mostrarToast( "[Bandera3] onRestart");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onPause() {
        super.onPause();
        mostrarToast( "[Bandera3] onPause");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onStop() {
        super.onStop();
        mostrarToast( "[Bandera3] onStop");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostrarToast( "[Bandera3] onDestroy");
    }

    //----------------------------------------------------------------------------------------------

    public void btnAccionClick ( View v ) {
        if ( v.getId() == R.id.btnBand3Atras ) {
            finish (); // Terminar este activity
        }
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarToast ( CharSequence mensaje ) {
        Toast.makeText( this, mensaje, Toast.LENGTH_SHORT ).show();
    }

    //----------------------------------------------------------------------------------------------

}