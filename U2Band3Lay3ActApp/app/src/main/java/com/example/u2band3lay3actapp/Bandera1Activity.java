/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                        Clase que muestra una bandera
:*
:*  Archivo     : Bandera1Activity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 12/Sept/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : En esta clase se muestra la bandera de México y el Acerca De.

:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:* 14/Sept      Jorge Cisneros       Se agregaron los métodos relacionados con el ciclo de
                                     vide de un activity y que se muestren en la app.
:*------------------------------------------------------------------------------------------*/

package com.example.u2band3lay3actapp;

    //----------------------------------------------------------------------------------------------

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

    //----------------------------------------------------------------------------------------------

public class Bandera1Activity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.bandera1_layout );
        mostrarToast ( "[Bandera1] onCreate" );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onStart () {
        super.onStart();
        mostrarToast( "[Bandera1] onStart");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onResume () {
        super.onResume();
        mostrarToast( "[Bandera1] onResume");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onRestart () {
        super.onRestart();
        mostrarToast( "[Bandera1] onRestart");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onPause() {
        super.onPause();
        mostrarToast( "[Bandera1] onPause");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onStop() {
        super.onStop();
        mostrarToast( "[Bandera1] onStop");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostrarToast( "[Bandera1] onDestroy");
    }

    //----------------------------------------------------------------------------------------------

    public void btnAccionClick (View v ) {
        if ( v.getId() == R.id.btnSalir ) {
            finish (); // Terminar la app
        } else if ( v.getId() == R.id.btnBand1Siguiente ) {
            //Cambiar al activity de la bandera 2
            Intent intent = new Intent ( this, Bandera2Activity.class );
            startActivity ( intent );
        } else if ( v.getId() == R.id.btnAcercaDe ) {
            View layout = getLayoutInflater().inflate ( R.layout.acercade_layout, null );

            TextView txvNombre = layout.findViewById ( R.id.txvNombre );
            TextView txvNoDeControl = layout.findViewById ( R.id.txvNoDeControl );
            TextView txvApp = layout.findViewById ( R.id.txvApp );

            AlertDialog.Builder builder = new AlertDialog.Builder ( this );

            builder.setTitle( "Acerca De..." ).setIcon ( R.drawable.itl ).setView ( layout )
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
        }
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarToast ( CharSequence mensaje ) {
        Toast.makeText( this, mensaje, Toast.LENGTH_SHORT ).show();
    }

    //----------------------------------------------------------------------------------------------

}