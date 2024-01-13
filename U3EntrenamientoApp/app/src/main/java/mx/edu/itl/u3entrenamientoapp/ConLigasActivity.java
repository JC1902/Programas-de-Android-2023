/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                     Clase para los ejercicios con ligas
:*
:*  Archivo     : ConLigasActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 23/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase que inicia el activity con la descripción de un ejercicio
                  con datos ya predeterminados para mostrar la funcionalidad
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  26/Oct/23   Jorge Cisneros       Se cambió el adapter del listview para permitir el
                                     uso de imagenes en cada elemeto de la lista
    29/Oct/23   Jorge Cisneros       Se usaron los métodos de putExtra para enviar datos
                                     a otro activity usando claves especificas para cada dato
                                     a enviar
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3entrenamientoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

//--------------------------------------------------------------------------------------------------

public class ConLigasActivity extends AppCompatActivity {

    Intent intent;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_con_ligas );
    }

    //----------------------------------------------------------------------------------------------

    public void btnEjercicioUno ( View v ) {

        View layout = getLayoutInflater().inflate( R.layout.activity_ejercicio_descripcion, null );

        TextView txtEjercicio = layout.findViewById( R.id.txtDescripcion );
        RatingBar barDificultad = layout.findViewById( R.id.rbDificultad );

        // Usando los métodos putExtra de la variable intent mandamos datos a otro activity, con
        // una clave para identificar a cada dato

        if ( v.getId() == R.id.ibtnLiga1 ) {
            intent = new Intent(this, EjercicioDescripcionActivity.class);

            intent.putExtra( "ejercicio", "Correr en el sitio" );

            // Con el intent inicializado mandamos los valores que queremos al activity de los ejercicios
            intent.putExtra( "desc", "Coloca una banda de resistencia alrededor de tus piernas, justo por encima de las rodillas.\n" +
                    "\n" +
                    "Ponte de pie con los pies a la altura de las caderas y asegúrate de que la banda esté tensa.\n" +
                    "\n" +
                    "Mantén una postura erguida con los hombros hacia atrás y el núcleo comprometido.\n" +
                    "\n" +
                    "Comienza a correr en el sitio, levantando las rodillas hacia el pecho mientras mantienes una resistencia constante en la banda.\n" +
                    "\n" +
                    "Intenta mantener un ritmo constante y un movimiento fluido.\n" +
                    "\n" +
                    "Continúa corriendo en el sitio durante el tiempo deseado o el número de repeticiones planificado." );

            intent.putExtra( "dif", 2.0F );

            startActivity(intent);
        } else if ( v.getId() == R.id.ibtnLiga2 ) {
            intent = new Intent(this, EjercicioDescripcionActivity.class);

            intent.putExtra( "ejercicio", "Elevación pélvica" );

            intent.putExtra( "desc", "Acuéstate boca arriba en una estera con las rodillas dobladas y los pies planos en el suelo, a la altura de las caderas.\n" +
                    "\n" +
                    "Coloca una banda de resistencia alrededor de tus muslos, justo por encima de las rodillas.\n" +
                    "\n" +
                    "Descansa los brazos a los lados con las palmas hacia abajo.\n" +
                    "\n" +
                    "Engancha los glúteos y el núcleo y presiona los talones en el suelo.\n" +
                    "\n" +
                    "Levanta lentamente la pelvis hacia arriba, manteniendo los pies y los hombros en el suelo.\n" +
                    "\n" +
                    "Aprieta los glúteos en la parte superior y luego baja la pelvis de nuevo hacia abajo.\n" +
                    "\n" +
                    "Realiza el número deseado de repeticiones, manteniendo la tensión en la banda durante todo el movimiento.\n" +
                    "\n" +
                    "Asegúrate de mantener una técnica adecuada y evitar arquear la espalda baja." );

            intent.putExtra( "dif", 4.0F );

            startActivity(intent);
        } else if ( v.getId() == R.id.ibtnLiga3 ) {
            intent = new Intent(this, EjercicioDescripcionActivity.class);

            intent.putExtra( "ejercicio", "Sentadillas" );

            intent.putExtra( "desc", "Coloca una banda de resistencia alrededor de tus piernas, justo por encima de las rodillas.\n" +
                    "\n" +
                    "Párate con los pies a la altura de las caderas y los dedos de los pies ligeramente apuntando hacia afuera.\n" +
                    "\n" +
                    "Asegúrate de que la banda esté tensa y que la resistencia esté equilibrada en ambas piernas.\n" +
                    "\n" +
                    "Mantén una postura erguida con los hombros hacia atrás y el núcleo comprometido.\n" +
                    "\n" +
                    "Baja lentamente el cuerpo hacia abajo, doblando las rodillas y empujando las caderas hacia atrás, como si te estuvieras sentando en una silla.\n" +
                    "\n" +
                    "Continúa bajando hasta que tus muslos estén paralelos al suelo o hasta donde puedas mantener una buena forma.\n" +
                    "\n" +
                    "Luego, impúlsate hacia arriba a través de los talones para volver a la posición inicial.\n" +
                    "\n" +
                    "Repite el movimiento durante el número deseado de repeticiones, manteniendo la resistencia constante en la banda." );

            intent.putExtra( "dif", 7.5F );

            startActivity(intent);
        } else if ( v.getId() == R.id.ibtnLiga4 ) {
            intent = new Intent(this, EjercicioDescripcionActivity.class);

            intent.putExtra( "ejercicio", "Zancadas" );

            intent.putExtra( "desc", "Coloca una banda de resistencia alrededor de tus piernas, justo por encima de las rodillas.\n" +
                    "\n" +
                    "Párate de pie con los pies a la altura de las caderas y asegúrate de que la banda esté tensa.\n" +
                    "\n" +
                    "Mantén una postura erguida con los hombros hacia atrás y el núcleo comprometido.\n" +
                    "\n" +
                    "Da un paso hacia adelante con una de las piernas, doblando ambas rodillas para bajar el cuerpo hacia el suelo.\n" +
                    "\n" +
                    "A medida que bajas, asegúrate de que ambas rodillas estén dobladas a aproximadamente 90 grados.\n" +
                    "\n" +
                    "Mantén la resistencia constante en la banda a medida que das el paso hacia adelante y regresas a la posición inicial.\n" +
                    "\n" +
                    "Repite el movimiento con la otra pierna, alternando entre las piernas para realizar zancadas.\n" +
                    "\n" +
                    "Continúa haciendo zancadas durante el número deseado de repeticiones, manteniendo la tensión en la banda en todo momento." );

            intent.putExtra( "dif", 10.0F );

            startActivity(intent);
        } else {
            View noImplemmentado = getLayoutInflater().inflate( R.layout.alerta_no_implementado, null );

            TextView txtLoSiento = noImplemmentado.findViewById( R.id.txtLoSiento );
            TextView txtRazon =  noImplemmentado.findViewById( R.id.txtRazon );

            AlertDialog.Builder builder = new AlertDialog.Builder( this );

            builder.setTitle( "Lo lamento" ).setIcon( R.drawable.itl ).setView( noImplemmentado )
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
    }

    //----------------------------------------------------------------------------------------------

    public void imbtnRegresarClick ( View v ) {
        finish ();
    }

    //----------------------------------------------------------------------------------------------

}