/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                                  Clase MenuPopup
:*
:*  Archivo     : MenuPopupActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase con ejemplo que muestra el uso de un MenuPopup
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  02/Nov/23   Jorge Cisneros       Se cambiaron los textos de los apodos y se agregó
                                     el uso de VideoView para mostrar videos al azar
                                     cuando el usuario seleccione un apodo
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MenuPopupActivity extends AppCompatActivity implements View.OnLongClickListener,
                                                                    PopupMenu.OnMenuItemClickListener {

    EditText edtApodo;

    Random random = new Random();

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_popup);

        edtApodo = (EditText) findViewById ( R.id.edtApodo );
        // Establecemos un listener para el evento LongClick sobre el editText del Apodo
        edtApodo.setOnLongClickListener( this );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();

        if ( id == R.id.edtApodo ) {
            configurar_popmenu_apodo( v );
            return true;
        }

        return false;
    }

    //----------------------------------------------------------------------------------------------

    private void configurar_popmenu_apodo ( View v ) {
        PopupMenu popupMenu = new PopupMenu( this, v );
        popupMenu.getMenuInflater().inflate( R.menu.menu_popup_apodo, popupMenu.getMenu() );

        popupMenu.setOnMenuItemClickListener( this );
        popupMenu.show();
    }

    //----------------------------------------------------------------------------------------------


    @Override
    public boolean onMenuItemClick ( MenuItem item ) {
        int id = item.getItemId();

        if ( id == R.id.mniApodoAmlo ) {
            edtApodo.setText( "Chile piquin" );
            mostrarOpcionAgregada ();
        } else if ( id == R.id.mniApodoBorolas ) {
            edtApodo.setText( "Huevun" );
            mostrarOpcionAgregada ();
        } else if ( id == R.id.mniApodoPenita ) {
            edtApodo.setText( "Pedrito Zola" );
            mostrarOpcionAgregada ();
        } else {
            return false;
        }

        return true;
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarOpcionAgregada () {
        int numVideo = random.nextInt( 4 ) + 1;
        String videoPath;

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle("Buen día :D " + edtApodo.getText() );

        VideoView videoView = new VideoView( this );

        switch ( numVideo ) {
            case 1:
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.para_wa;
                break;
            case 2:
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tuntuntun;
                break;
            case 3:
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.huh;
                break;
            case 4:
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.gato_sad;
            default:
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.gato_sad;
        }

        videoView.setVideoPath( videoPath );
        videoView.start();

        builder.setView( videoView );

        builder.setPositiveButton( "Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick( DialogInterface dialog, int which ) {
                videoView.stopPlayback();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //----------------------------------------------------------------------------------------------

}
