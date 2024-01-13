package mx.edu.itl2018b.a85360673.u4reproduccionvideoapp;

import android.content.Intent;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String ruta;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------------------------------------------------------------------------------------------

    public void btnDesdeAppClick ( View v ) {
        // Reproducir un video incluido en la app en la carpeta raw
        ruta = "android.resource://" + this.getPackageName() + "/" + R.raw.gato_sad;
        lanzarVideoActiviy ();
    }

    //----------------------------------------------------------------------------------------------

    public void btnDesdeInternetClick ( View v ) {
        // Reproducir un video desde internet
        ruta = "https://drive.google.com/uc?id=1tbrwMcuaK5bZ3sVFOdPY1DLFKMFii2K7";
        lanzarVideoActiviy ();
    }

    //----------------------------------------------------------------------------------------------

    public void btnDesdeAlmIntClick ( View v ) {
        // Reproducir un video en la carpeta DCIM del almacenamiento interno
        ruta = "file://" + Environment.getExternalStorageDirectory()
                .getPath() + "/DCIM/gato_sad.mp4";
        lanzarVideoActiviy ();
    }

    //----------------------------------------------------------------------------------------------

    private void  lanzarVideoActiviy () {
        Intent intent = new Intent ( this, VideoActivity.class ) ;
        intent.putExtra ( "rutaVideo", ruta );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent( this, AcercaDeActivity.class );
        startActivity( intent );
    }

}
