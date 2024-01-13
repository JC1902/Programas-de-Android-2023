/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                      Clase para grabar y reproducir audio
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 17/Nov/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase principal de la aplicación donde se encuentra metodos para grabar,
                  detener y reproducir audio usando métodos de las clases de MediaRecorder
                  y MediaPlayer.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package teclag.c85360673.u4grabaraudioapp;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import teclag.c20130789.androidlib.util.permisos.ChecadorDePermisos;
import teclag.c20130789.androidlib.util.permisos.PermisoApp;

public class MainActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    private PermisoApp [] permisosReq = {
            new PermisoApp( Manifest.permission.RECORD_AUDIO, "Audio", true ),
            new PermisoApp( Manifest.permission.WRITE_EXTERNAL_STORAGE, "Guardar", true ),
            new PermisoApp( Manifest.permission.READ_EXTERNAL_STORAGE, "Reproducir", true )
    };

    //----------------------------------------------------------------------------------------------

    private TextView txtvMensajes;
    private EditText edtGuardarComo;
    private Button   btnGrabar;
    private Button   btnDetener;
    private Button   btnReproducir;
    private MediaRecorder medRecorder;
    private MediaPlayer medPlayer;
    private String ruta = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM" +
                          File.separator;
    private ImageView imvAccion;

    private String fichero;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtvMensajes     = findViewById ( R.id.txtvMensaje );
        edtGuardarComo   = findViewById ( R.id.edtGuardarComo );
        btnGrabar        = findViewById ( R.id.btnGrabar );
        btnDetener       = findViewById ( R.id.btnDetener );
        btnReproducir    = findViewById ( R.id.btnReproducir );
        imvAccion        = findViewById ( R.id.imvAccion );

        ChecadorDePermisos.checarPermisos( this, permisosReq );

        btnGrabar.setEnabled( true );
        btnDetener.setEnabled( false );
        btnReproducir.setEnabled( true );
        txtvMensajes.setText( "" );
        imvAccion.setImageResource( R.drawable.reproduciendo );

    }

    //----------------------------------------------------------------------------------------------
    // Se revisa si los permisos están dados para la app
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS ) {
            ChecadorDePermisos.verificarPermisosSolicitados( this, permisosReq, permissions, grantResults );
        }
    }

    //----------------------------------------------------------------------------------------------
    // Se usa el medRecorder para comenzar la grabación en el archivo con el nombre dado y la extensión
    // .3gp
    public void btnGrabarClick (View v ) {
        fichero = ruta + edtGuardarComo.getText().toString() + ".3gp";

        medRecorder = new MediaRecorder();

        medRecorder.setAudioSource( MediaRecorder.AudioSource.MIC );

        medRecorder.setOutputFormat( MediaRecorder.OutputFormat.THREE_GPP );
        medRecorder.setAudioEncoder( MediaRecorder.AudioEncoder.AMR_WB );

        medRecorder.setOutputFile( fichero );

        try {
            btnGrabar.setEnabled( false );
            btnDetener.setEnabled( true );
            btnReproducir.setEnabled( false );
            txtvMensajes.setText( "Grabando..." );
            imvAccion.setImageResource( R.drawable.grabando );

            medRecorder.prepare();
            medRecorder.start();
        } catch ( IOException ex ) {
            btnGrabar.setEnabled( true );
            btnDetener.setEnabled( false );
            btnReproducir.setEnabled( false );
            txtvMensajes.setText( "" );
            Toast.makeText( this, ex.toString(), Toast.LENGTH_SHORT ).show();
        }
    }

    //----------------------------------------------------------------------------------------------
    // Detenemos la grabación
    public void btnDetenerClick ( View v ) {
        btnGrabar.setEnabled( true );
        btnDetener.setEnabled( false );
        btnReproducir.setEnabled( true );
        txtvMensajes.setText( "" );
        imvAccion.setImageResource( R.drawable.reproduciendo );

        medRecorder.stop();
        medRecorder.release();
    }

    //----------------------------------------------------------------------------------------------
    // Reproducimos el audio pasando la fuente al medPlayer
    public void btnReproducirClick ( View v ) {
        medPlayer = new MediaPlayer();

        try {
            medPlayer.setDataSource( fichero );
            medPlayer.prepare();
            medPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    txtvMensajes.setText( "Reproduciendo..." );
                    imvAccion.setImageResource( R.drawable.reproduciendo );
                    btnGrabar.setEnabled( false );
                    btnDetener.setEnabled( false );
                    btnReproducir.setEnabled( false );


                    mediaPlayer.start();
                }
            });

            medPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    txtvMensajes.setText( " " );
                    imvAccion.setImageResource( R.drawable.reproduciendo );
                    btnGrabar.setEnabled( true );
                    btnDetener.setEnabled( false );
                    btnReproducir.setEnabled( true );

                    mediaPlayer.release();
                }
            });
        } catch ( IOException ex ) {
            // Si no se encuentra el audio o hay un error con el archivo se lanza esta excepción
            btnGrabar.setEnabled( true );
            btnDetener.setEnabled( false );
            btnReproducir.setEnabled( false );
            txtvMensajes.setText( "" );
            imvAccion.setImageResource( R.drawable.reproduciendo );
            Toast.makeText( this, "Fallo al reproducir el audio", Toast.LENGTH_SHORT ).show();
        }
    }

    //----------------------------------------------------------------------------------------------

    public void fabAcercaDeClick ( View v ) {
        Intent intent = new Intent( MainActivity.this, AcercaDeActivity.class );
        startActivity( intent );
    }

    //----------------------------------------------------------------------------------------------

}
