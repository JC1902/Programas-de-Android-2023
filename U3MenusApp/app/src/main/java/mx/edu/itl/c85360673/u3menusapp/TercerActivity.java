/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                       Clase de elementos personalizada
:*
:*  Archivo     : TercerActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase del tercer activity con menu en comun con funciones con diferentes
                  resultados a las del segundo activity
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  02/Nov/23   Jorge Cisneros       El cambio de color se cambio por poner una imagen de fondo
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;



public class TercerActivity extends MenuComunActivity {

    LinearLayout layout;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        layout = (LinearLayout) findViewById ( R.id.layoutPrincipal );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == R.id.mniCambiarFondo) {
            layout.setBackgroundResource( R.drawable.bonk );
            return true;
        } else {
            return super.onOptionsItemSelected( item );
        }
    }

    //----------------------------------------------------------------------------------------------

}
