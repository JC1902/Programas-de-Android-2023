/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*        Activity que muestra diferentes despliegues de cuadros de mensaje
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 20/Sept/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Este es el activity principal de la app, la cual despliega una pantalla
                  con botones que despliegan una muestra de los diferntes cuadros de mensaje
                  en Android.
                  La app ilustra los cuadros de mensaje que se puede desplegar con las clases:
                  1. Toast
                  2. Snackbar
                  3. AlertDialog
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u2cuadrosmensajeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//--------------------------------------------------------------------------------------------------

    public void btnToastCortoClick  ( View v ){
        Toast.makeText( this, "Toast corto", Toast.LENGTH_SHORT ).show();
    }
//--------------------------------------------------------------------------------------------------

    public void btnToastLargoClick ( View v ) {
        Toast.makeText( this, "Toast largo", Toast.LENGTH_LONG ).show();
    }

//--------------------------------------------------------------------------------------------------

    public void btnSnackBarClick ( View v ) {
        Snackbar.make( v, "Este es un SnackBar", Snackbar.LENGTH_SHORT ).show();
    }

//--------------------------------------------------------------------------------------------------
    public void btnMensajeSimpleClick ( View v ){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setMessage( "Cudaro de mensaje simple" ).create().show();
    }

//--------------------------------------------------------------------------------------------------

    //Cuadro de mensaje con boton OK
    public void btnMensajeBtnOK ( View v ){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setMessage( "Mensaje con boton OK" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i ) {
                        Toast.makeText( MainActivity.this, "Click acpetar"
                                , Toast.LENGTH_SHORT ).show();
                    }
                })
                .create()
                .show();
    }

//--------------------------------------------------------------------------------------------------

    //Cuadros de mensaje con botones OK y CANCEL
    public void btnMensajeBtnOKCANCEL ( View v ){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setMessage( "Mensaje con botones OK y CANCEL" )
                .setTitle( "Android" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i ) {
                        mostrarToast( "Click aceptar" );
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i ) {
                        //Cerrar el cuadro de mensaje
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable( false ) //Evita que el cuadro se cierre al dar click fuera de él.
                .create()
                .show();
    }

//--------------------------------------------------------------------------------------------------

    //Cuadro con lista de opciones simples
    CharSequence [] colores = { "Verde", "Blanco", "Rojo"};
    public void btnCuadroListaOpcionesClick ( View v ){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Seleccione:" )
                .setItems( colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Se muestra el color seleccionado
                        mostrarToast( colores[ i ].toString() );
                    }
                })
                .create()
                .show();
    }

//--------------------------------------------------------------------------------------------------

    //Cuadro con lista de seleccion unica ( con radioButton )
    int colorSeleccionado = 2 ; //Rojo
    public void btnCuadroListaOpcSelecUnicaClick ( View v ){
        int colorDefault      = 2 ; //Rojo

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Seleccione: ")
                .setSingleChoiceItems( colores, colorDefault, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Mostramos el color seleccionado
                        mostrarToast( colores[ i ] );
                        colorSeleccionado = i;
                    }
                } )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Mostrar el color seleccionado al cerrar el cuadro
                        mostrarToast( "Color seleccionado: " + colores[ colorSeleccionado ] );
                    }
                })
                .create()
                .show();
    }

//--------------------------------------------------------------------------------------------------

    //Cuadro de listade opciones seleccion multiple ( con checklist )
    boolean coloresDefaoult [] = { false, false, false };
    ArrayList< CharSequence > coloresFavoritos = new ArrayList<>();
    public void btnCuadroListaOpcSelecMultiClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Marque sus colores favoritos:")
                .setMultiChoiceItems( colores, coloresDefaoult, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if( b ){
                            //Si marco un colore favorito agregarlo a los colores favoritos
                            coloresFavoritos.add( colores[ i ] );
                        }else{
                            //Si desmarco un color removerlo de los colores favoritos
                            coloresFavoritos.remove( colores [ i ] );
                        }
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Mostrar la lsita de clores favoritos seleccionados
                        mostrarToast( coloresFavoritos.toString() );
                    }
                })
                .create()
                .show();
    }

//--------------------------------------------------------------------------------------------------

    public void btnCuadroLayoutIncrustadoClick ( View v ) {
        View layout = getLayoutInflater().inflate( R.layout.login_layout, null );
        EditText edtUsuario = layout.findViewById( R.id.edtUsuario );
        EditText edtContrasena = layout.findViewById( R.id.edtContrasena );

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Inicio de sesión" )
                .setIcon( R.drawable.itl )
                .setView( layout )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String usuario = edtUsuario.getText().toString();
                        String contrasena = edtContrasena.getText().toString();

                        mostrarToast( "Bienvenido " + usuario + "( " + contrasena + " )" );
                    }
                } )
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } ).create().show();
    }

//--------------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        View layout = getLayoutInflater().inflate( R.layout.acercade_layout, null );
        TextView txtNombre = layout.findViewById( R.id.txtNombre );
        TextView txtNoDeControl = layout.findViewById( R.id.txtNoDeControl );
        TextView txtApp = layout.findViewById( R.id.txtApp );

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Acerca De..." )
                .setIcon( R.drawable.itl )
                .setView( layout )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nombre = txtNombre.getText().toString();
                    }
                } ).create().show();
    }

//--------------------------------------------------------------------------------------------------

    public void mostrarToast (  CharSequence mensaje ){
        Toast.makeText( this, mensaje, Toast.LENGTH_SHORT ).show();
    }

//--------------------------------------------------------------------------------------------------
}