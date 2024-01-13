/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                             Clase segundo activity
:*
:*  Archivo     : SegundoActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 02/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase del segundo activity con menu comun que tiene ciertas funciones
                  que serán diferentes a las del tercer activity
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  02/Nov/23   Jorge Cisneros       En la opcion de Acerca De se cambio para mostrar el
                                     layout del acerca de, se cambio el cambio de color de fondo
                                     por cambiar a una imagen y en la Opcion agregada se
                                     dio la funcion de reproducir un video
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3menusapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;



public class SegundoActivity extends MenuComunActivity {

    ConstraintLayout layout;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        layout = (ConstraintLayout) findViewById ( R.id.layoutPrincipal );
    }

    //----------------------------------------------------------------------------------------------

    // Se sobreescribe el metodo onCreateOptionsMenu para agregar la nueva opcion
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Se llama a super para que recree el menu con las opciones en comun
        super.onCreateOptionsMenu(menu);

        // Agregamos la nueva opcion
        MenuItem mni = menu.add ( Menu.NONE, 44191944, Menu.NONE, "Opcion agregada"  );

        return true;
    }

    //----------------------------------------------------------------------------------------------

    // Se sobre escribe el metodo onOptionsItemSelected para manejar la nueva opcion agregada
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == R.id.mniCambiarFondo) {
            layout.setBackgroundResource( R.drawable.cheems );
            return true;
        } else if ( id == 44191944 ) {
            mostrarOpcionAgregada();
            return true;
        } else {
            return super.onOptionsItemSelected( item );
        }
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarOpcionAgregada () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Buen día :D");

        VideoView videoView = new VideoView(this);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.para_wa;
        videoView.setVideoPath(videoPath);
        videoView.start();

        builder.setView(videoView);

        builder.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                videoView.stopPlayback();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //----------------------------------------------------------------------------------------------

}
