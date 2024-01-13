/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                             Clase ocultar teclado
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Luis Fernando Gil Vazquez
                  Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase con metodos para ocultar el teclado usando variables
                  InputMethodManager.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class OcultarTecladoAdaptador implements View.OnClickListener {

    private Activity activity;

    public OcultarTecladoAdaptador(Activity activity ) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        View view = activity.getCurrentFocus();
        if ( view != null ) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService ( Context.INPUT_METHOD_SERVICE ) ;
            imm.hideSoftInputFromWindow (
                    view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS
            );
        }
    }
}
