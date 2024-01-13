/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                                Calculadora IMC
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 06/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Calculadora de IMC con método para mostrar la condición de salud
                  según el valor resultante. Para mostrar el resultado se usa la
                  clase AlertDialog.Builder; En esta variante todas las cadenas se
                  cambiaron para que al cambiar el idioma del dispositivos estas
                  tuvieran el mismo idioma.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  07/Oct      Jorge Cisneros       Cambiar Strings státicos por los strings que se
                                     encuentran en el strings.xml
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//----------------------------------------------------------------------------------------------

public class MainActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------------------------------------------------------------------------------------------
    // Método para calcular el IMC y mostrar el resultado y la condición de salud
    public void btnCalcularIMCClick ( View v ) {
        float peso = 0, estatura = 0, IMC = 0;

        try {
            // Obtener el valor de los campos de texto
            EditText edtPeso = findViewById(R.id.etxPeso);
            EditText edtEstatura = findViewById(R.id.etxEstatura);

            // Convertir esos valores a tipo float
            peso = Float.parseFloat(edtPeso.getText().toString());
            estatura = Float.parseFloat(edtEstatura.getText().toString());

            if ( peso == 0 || estatura == 0 ) {
                Toast.makeText( this, R.string.valor_0, Toast.LENGTH_LONG).show();
            } else {

                IMC = peso / (estatura * estatura);
                CharSequence condSalud = mostrarCondicionSalud(IMC);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle( R.string.titulo_app )
                        .setMessage( getString( R.string.imc_igual ) + IMC + "\n" + getString( R.string.condicion_salud ) + condSalud)
                        .setPositiveButton( R.string.aceptar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();
            }
        } catch ( NumberFormatException e ) {
            // En caso de que los datos estén equivocados salta este Toast
            Toast.makeText( this, R.string.valores_correctos, Toast.LENGTH_LONG).show();
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        // Cambiar al activity del Acerca De
        Intent intent = new Intent( this, AcercaDeActivity.class );
        startActivity( intent );
    }

    //----------------------------------------------------------------------------------------------

    // Método para comprobar la condición de salud según el IMC
    public CharSequence mostrarCondicionSalud ( float IMC ) {
        String condicionSalud = "";

        if ( IMC <= 15 ) {
            condicionSalud = getString( R.string.delgadez_muy_severa );
        } else if ( IMC > 15 && IMC <= 15.9 ) {
            condicionSalud = getString( R.string.delgadez_severa );
        } else if ( IMC >= 16 && IMC <= 18.4 ) {
            condicionSalud = getString( R.string.delgadez );
        } else if ( IMC >= 18.5 && IMC <= 24.9 ) {
            condicionSalud = getString( R.string.peso_saludable );
        } else if ( IMC >= 25 && IMC <= 29.9 ) {
            condicionSalud = getString( R.string.sobrepeso );
        } else if ( IMC >= 30 && IMC <= 34.9 ) {
            condicionSalud = getString( R.string.obesidad_moderada );
        } else if ( IMC >= 35 && IMC <= 39.9 ) {
            condicionSalud = getString( R.string.obesidad_severa );
        } else if ( IMC >= 40 ) {
            condicionSalud = getString( R.string.obesidad_muy_severa );
        }

        return condicionSalud;
    }

    //----------------------------------------------------------------------------------------------
}