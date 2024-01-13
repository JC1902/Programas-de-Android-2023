/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                      Clase de ejercicios sin instrumentos
:*
:*  Archivo     : SinInstrumentosActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 21/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase que incluirá los datos para cada uno de los ejercicios que
                  no requieren instrumentos como pesas o ligas. En este momento solo
                  se incluye el metodo para regresar al activity principal
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

public class SinInstrumentosActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_instrumentos);
    }

    //----------------------------------------------------------------------------------------------

    public void imbtnRegresarSinInstClick ( View v ) {
        finish ();
    }

    //----------------------------------------------------------------------------------------------

}