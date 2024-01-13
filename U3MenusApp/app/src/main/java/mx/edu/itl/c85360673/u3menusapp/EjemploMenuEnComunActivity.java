/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                              Clase Menu en Comun
:*
:*  Archivo     : EjemploMenuEnComunActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase para mostrar los layouts con los ejemplos de Menu en comun
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;




public class EjemploMenuEnComunActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_menu_en_comun);
    }

    //----------------------------------------------------------------------------------------------

    public void btnActivity2Click ( View v ) {
        Intent i = new Intent ( this, SegundoActivity.class );
        startActivity ( i );
    }

    //----------------------------------------------------------------------------------------------

    public void btnActivity3Click ( View v ) {
        Intent i = new Intent ( this, TercerActivity.class );
        startActivity ( i );
    }

    //----------------------------------------------------------------------------------------------

}
