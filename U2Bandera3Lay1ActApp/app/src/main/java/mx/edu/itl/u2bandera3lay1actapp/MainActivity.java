/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                    Clase que muestra distintas banderas.
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 07/Sept/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Esta aplicación muestra tres distintas banderas, utilizando
                  tres distintos layouts con solo un activity.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u2bandera3lay1actapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//--------------------------------------------------------------------------------------------------
public class MainActivity extends AppCompatActivity {

    //--------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bandera1_layout);
    }

    //--------------------------------------------------------------------------------------------------

    public void btnAccionClick ( View v ) {
        if ( v.getId() == R.id.btnSalir ) {
            // Terminar la app
            finish ();
        } else if ( v.getId() == R.id.btnBand1Siguiente ) {
            // Desplegar la bandera 2
            setContentView ( R.layout.bandera2_layout );
        } else if ( v.getId() == R.id.btnBand2Atras ) {
            // Desplegar bandera 1
            setContentView( R.layout.bandera1_layout );
        } else if ( v.getId() == R.id.btnBand2Siguiente ) {
            // Desplegar bandera 3
            setContentView( R.layout.bandera3_layout );
        } else if ( v.getId() == R.id.btnBand3Atras ) {
            // Desplegar bandera 2
            setContentView( R.layout.bandera2_layout );
        } else if ( v.getId() == R.id.btnAcercaDe ) {
            View layout = getLayoutInflater().inflate ( R.layout.acercade_layout, null );

            TextView txvNombre = layout.findViewById ( R.id.txvNombre );
            TextView txvNoDeControl = layout.findViewById ( R.id.txvNoDeControl );
            TextView txvApp = layout.findViewById ( R.id.txvApp );

            AlertDialog.Builder builder = new AlertDialog.Builder ( this );

            builder.setTitle( "Acerca De..." ).setIcon ( R.drawable.itl ).setView ( layout )
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
        }
    }

    //--------------------------------------------------------------------------------------------------

}