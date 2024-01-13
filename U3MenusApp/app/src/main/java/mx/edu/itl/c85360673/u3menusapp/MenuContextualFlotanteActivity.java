/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                         Clase Menu Contextual Flotante
:*
:*  Archivo     : MenuContextualFlotanteActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase con las funciones para los menus contextuales flotantes que
                  incluye un ejemplo simple de como se implementan
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  03/Nov/23   Jorge Cisneros       Se agregó el poner una sombra de color al texto
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MenuContextualFlotanteActivity extends AppCompatActivity {

    EditText edtNombre;
    EditText edtApellido;
    Boolean isShadowed;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contextual_flotante);
        isShadowed = false;

        edtNombre = (EditText) findViewById ( R.id.edtNombre );
        // Registramos el EditText del Nombre para tener un menu contextual flotante
        //...
        registerForContextMenu( edtNombre );

        edtApellido = (EditText) findViewById ( R.id.edtApellido );
        // Registramos el EditText del Apellido para tener un menu contextual flotante
        //...
        registerForContextMenu( edtApellido );

    }

    //----------------------------------------------------------------------------------------------

    // onCreateContextMenu se invoca al registrar un View con registerForContextMenu ()
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // Dependiendo del objeto View se le crea su menu contextual flotante que le corresponda
        //...
        if ( v.getId() == R.id.edtNombre ) {
            getMenuInflater().inflate( R.menu.menu_contextual_nombre, menu );
        } else if ( v.getId() == R.id.edtApellido ) {
            getMenuInflater().inflate( R.menu.menu_contextual_apellido, menu );
        }

    }

    //----------------------------------------------------------------------------------------------

    // Metodo para manejar la opcion de menu contextual seleccionada por el usuario
    @Override
    public boolean onContextItemSelected ( MenuItem item ) {
        int id = item.getItemId();

        if ( id == R.id.mniSombra) {
            ponerQuitarSombra( edtNombre, Color.BLUE );
        } else if ( id == R.id.mniFuenteColorNegro ) {
            edtNombre.setTextColor( Color.BLACK );
        } else if ( id == R.id.mniFuenteColorRojo ) {
            edtNombre.setTextColor( Color.RED );
        } else if ( id == R.id.mniFondoMagenta) {
            edtApellido.setBackgroundColor( Color.MAGENTA );
        }else if ( id == R.id.mniSombraApellido) {
            ponerQuitarSombra( edtApellido, Color.GREEN );
        } else {
            return super.onContextItemSelected( item );
        }

        return true;
    }

    //----------------------------------------------------------------------------------------------
    // Funcion para colocar o quitar una sombra al texto del EditText que se pase como argumento
    // para argumentos son el radio de la sombra, el desplazamiento de esta en el eje x y eje y
    // el color que tendra esta
    public void ponerQuitarSombra ( EditText edtTexto, int color ) {
        if ( isShadowed ) {
            edtTexto.setShadowLayer( 0.0F, 0, 0, Color.BLACK );
            isShadowed = false;
        } else {
            edtTexto.setShadowLayer( 10.0F, 2, 2, color );
            isShadowed = true;
        }
    }

    //----------------------------------------------------------------------------------------------

}


