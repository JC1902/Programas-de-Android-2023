/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                              Super clase Menu Comun
:*
:*  Archivo     : MenuComunActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Super clase que contiene el mostrar el Acerca De y la función para
                  cambiar el fondo de los ejemplos de Menu en comun
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



// Esta clase es la superclase de los Activity's que van a compartir un menu en comun
// En este caso el menu tendrá 2 opciones en comun: Acerca de y Cambiar el color de fondo de la pantalla.

public class MenuComunActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate ( R.menu.menu_comun, menu );
        return true;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent( this, AcercaDeActivity.class );

        if ( id == R.id.mniAcercaDe )
            startActivity( intent );
        else
            return  super.onOptionsItemSelected( item );

        return true;
    }

    //----------------------------------------------------------------------------------------------

}
