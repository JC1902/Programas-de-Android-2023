/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                      Clase con los datos de los ejercicios
:*
:*  Archivo     : EjercicioDescripcionActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 23/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase principal de la app donde se usa un Adaptador personalizado
                  para crear un listView con imagen y texto y un arrayList usando
                  la clase ItemModel para poder utilizar imagen y texto
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  26/Oct/23   Jorge Cisneros       Se agregaron diseños personalizados para el progressBar
                                     que marca el tiempo, además de usar un CardView para
                                     darle al botón de inicio esquinas redondeadas
    27/Oct/23   Jorge Cisneros       Al dialog que se muestra al final del tiempo se le agrego
                                     un diseño personalizado, además de usar la clase MediaPlayer
                                     para hacer que se reproduzca un audio
    28/Oct/23   Jorge Cisneros       Se cambio el diseño del ratingBar para en lugar de mostrar
                                     estrellas se muestre una barra con diferente color según
                                     la dificultad que se de al ejercicio
    29/Oct/23   Jorge Cisneros       Se usaron los métodos de la clase Intent getXXXXExtra para
                                     obtener los valores de otro activity mediante claves
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3entrenamientoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

//--------------------------------------------------------------------------------------------------

public class EjercicioDescripcionActivity extends AppCompatActivity {

    RatingBar brDificultad;
    TextView txtDescripcion;
    TextView txtEjercicio;
    ProgressBar barraTiempo;
    Handler handler;
    ImageButton btnInicio;
    MediaPlayer play;
    float dificultad;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ejercicio_descripcion );

        txtDescripcion = findViewById( R.id.txtDescripcion );
        txtEjercicio = findViewById( R.id.txtEjercicio);

        Intent intent = getIntent();

        // Aqui obtenemos los valos usando una clave que definimos en el activity de origen
        // En el caso del valor numerico le damos uno por default si no llega a encontrar la clave
        dificultad = intent.getFloatExtra( "dif", 10 );
        txtDescripcion.append( intent.getStringExtra( "desc" ) );
        txtEjercicio.setText( intent.getStringExtra( "ejercicio" ) );

        handler = new Handler ();

        barraTiempo = findViewById( R.id.pbTiempo );
        // Se obtine el valor máximo del progressBar
        barraTiempo.setProgress( barraTiempo.getMax() );

        brDificultad = findViewById( R.id.rbDificultad );
        // Colocamos el valor en el ratingBar y luego actualizamos su color
        brDificultad.setRating( dificultad );
        actualizarColorCalifBar ();

        // Inicializamos el MeidaPlayer y le decimos que audio reproducir
        play = MediaPlayer.create( this, R.raw.se_acabo );

        btnInicio = findViewById( R.id.btnInicio );

        // Evento para empezar a vaciar el progressBar
        btnInicio.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                empezarDecremento ();
            }
        });
    }

    //----------------------------------------------------------------------------------------------

    // Cuando se llame a este método se deja de usar el MediaPlayer y le damos el valor de null
    @Override
    protected void onDestroy () {
        super.onDestroy();

        if ( play != null ) {
            play.release();
            play = null;
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnTerminarClick ( View v ) {
        finish ();
    }

    //----------------------------------------------------------------------------------------------

    public void empezarDecremento () {
        int decremento = 5;

        final Runnable runnable = new Runnable () {
            @Override
            public void run () {
                // Obtenemos el progreso de la barra
                int progresoActual = barraTiempo.getProgress();
                if ( progresoActual > 0 ) {
                    // Si el progresoActual es mayor a cero seguimos restando
                    barraTiempo.setProgress( progresoActual - decremento );
                    handler.postDelayed(this, 1000 );
                } else if ( progresoActual == 0 ) {
                    // Cuando es igual a cero reproducimos el audio y mostramos el dialog de alerta
                    play.start ();
                    mostrarFinal ();
                }
            }
        };

        // Ejecuta el Runnable con un retraso inicial
        handler.postDelayed( runnable, 500 );
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarFinal () {
        View alertaPersonalizada = LayoutInflater.from( this )
                                   .inflate( R.layout.alerta_personalizada_layout, null );

        TextView txtTitulo = alertaPersonalizada.findViewById( R.id.txtTitulo );
        TextView txtLeyenda1 = alertaPersonalizada.findViewById( R.id.txtLeyendaUno );
        TextView txtLeyenda2 = alertaPersonalizada.findViewById( R.id.txtLeyendaDos );
        ImageView imgAlerta = alertaPersonalizada.findViewById( R.id.imgAlerta );

        // Le damos el diseño personalizado al AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder ( this, R.style.EstiloAlertDialogPersonalizado );

        // Le damos el fondo con el degradado y las esquinas redondeadas
        alertaPersonalizada.setBackgroundResource( R.drawable.dialog_redondo );

        builder.setTitle( "Bien hecho!!" ).setView( alertaPersonalizada )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss ();
                    }
                }).create ();

        // Cambiamos el color del Texto del boton aceptar
        Button botonAceptar = builder.show().getButton( DialogInterface.BUTTON_POSITIVE );
        botonAceptar.setTextColor( Color.BLACK );
    }

    //----------------------------------------------------------------------------------------------

    public void setColorCalifBar ( String color ) {
        // En este método se obtiene un string que se usa para poner el color de ese valor en hexadecimal
        LayerDrawable dificultad = ( LayerDrawable ) brDificultad.getProgressDrawable();
        dificultad.getDrawable( 2 ).setColorFilter( Color.parseColor( color ), PorterDuff.Mode.SRC_ATOP );
    }

    //----------------------------------------------------------------------------------------------

    public void actualizarColorCalifBar () {
        // El color cambia según el valor de la dificultad, se usa un float para hacerlo lo más
        // preciso posible
        if ( dificultad <= 2.5 ) {
            setColorCalifBar( "#00FF00" );
        } else if ( dificultad == 2.6 || dificultad <= 5 ) {
            setColorCalifBar( "#FFFF00" );
        } else if ( dificultad == 5.1 || dificultad <= 7.5 ) {
            setColorCalifBar( "#FF8000" );
        } else if ( dificultad == 7.6 || dificultad <= 10 ) {
            setColorCalifBar( "#FF0000" );
        }
    }

    //----------------------------------------------------------------------------------------------
}