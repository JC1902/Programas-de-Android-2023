/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                      Clase Acerca De para la aplicación
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 17/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase para el layout del Acerca De de la aplicación con un método para
                  regresar a la pantalla principal de esta.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package teclag.c85360673.u4grabaraudioapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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