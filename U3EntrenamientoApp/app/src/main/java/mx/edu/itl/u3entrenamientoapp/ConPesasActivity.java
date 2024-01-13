/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                        Clase para ejercicios con pesas
:*
:*  Archivo     : ConPesasActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 23/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase que incluirá los datos para cada uno de los ejercicios que
                  requieren pesas. En este momento solo se incluye el metodo para
                  regresar al activity principal
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

public class ConPesasActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_con_pesas );
    }

    //----------------------------------------------------------------------------------------------

    public void imbtnRegresarClick ( View v ) {
        finish ();
    }

    //----------------------------------------------------------------------------------------------

}