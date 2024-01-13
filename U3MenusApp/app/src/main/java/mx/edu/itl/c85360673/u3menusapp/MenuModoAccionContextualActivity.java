/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                           Clase Modo Accion Contextual
:*
:*  Archivo     : MenuModoAccionContextualActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase que muestra el cambio de una imagen según
                  el MenuItem que el usuario presione
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MenuModoAccionContextualActivity extends AppCompatActivity
                                              implements View.OnLongClickListener {

    ImageView imgvImagen;
    ActionMode mImagenActionMode = null;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_modo_accion_contextual);

        // El ImageView va a responder al click largo ( onLongClick )
        imgvImagen = ( ImageView ) findViewById ( R.id.imgvImagen);
        imgvImagen.setOnLongClickListener( this );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onLongClick ( View v ) {
        if ( v.getId() == R.id.imgvImagen ) {
            if ( mImagenActionMode != null ) {
                return false;
            }

            mImagenActionMode = startActionMode( mImagenActionModeListener );
            v.setSelected( true );
            return true;
        }

        return false;
    }

    //----------------------------------------------------------------------------------------------

    // Se define una variable que implementa la interface ActionMode.Callback
    // Esta variable fungirá como listener de la accion que se seleccione del menu contextual
    private ActionMode.Callback  mImagenActionModeListener = new ActionMode.Callback() {

        //------------------------------------------------------------------------------------------

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Se infla el menu que aparecerá en modo de accion contextual para la Imagen
            mode.getMenuInflater().inflate( R.menu.menu_modo_accion_contextual, menu );

            return true;
        }

        //------------------------------------------------------------------------------------------

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        //------------------------------------------------------------------------------------------

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // Se selecciono una opción de acción del menu contextual, ejecutar la accion que consiste en cambiar la imagen
            int id = item.getItemId();

            if ( id == R.id.mniModoAccionContextCopiar ) {
                imgvImagen.setImageResource( R.drawable.vileplume );
            } else if ( id == R.id.mniModoAccionContextCortar ) {
                imgvImagen.setImageResource( R.drawable.sylveon );
            } else if ( id == R.id.mniModoAccionContextPegar ) {
                imgvImagen.setImageResource( R.drawable.tentacruel );
            } else {
                return false;
            }

            return true;
        }

        //------------------------------------------------------------------------------------------

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // Anular el objeto ActionMode
            mImagenActionMode = null;
        }

        //------------------------------------------------------------------------------------------

    } ;

    //----------------------------------------------------------------------------------------------

}
