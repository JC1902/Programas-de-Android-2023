/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                              Clase Acerca De
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 21/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase del que contiene el acerca de la aplicación con el método
                  para regresar a la pantalla principal
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3entrenamientoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

//--------------------------------------------------------------------------------------------------

public class AcercaDeActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_acerca_de );
    }

    //----------------------------------------------------------------------------------------------

    public void btnRegresarClick ( View v ) {
        finish ();
    }

    //----------------------------------------------------------------------------------------------

}