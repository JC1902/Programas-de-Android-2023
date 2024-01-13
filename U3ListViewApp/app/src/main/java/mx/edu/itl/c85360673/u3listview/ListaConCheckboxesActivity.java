package mx.edu.itl.c85360673.u3listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaConCheckboxesActivity extends AppCompatActivity {

    private ListView lstvIniciales;
    private ArrayList<String> seleccionados;

    private String [] iniciales = { "Chimchar", "Snivy", "Turtwig", "Charmander", "Piplup",
                                   "Cyndaquil", "Chikorita", "Totodile", "Sprigatito", "Oshawott" } ;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_con_checkboxes);

        lstvIniciales = findViewById ( R.id.lstvIniciales );
        ArrayAdapter adaptador = new ArrayAdapter( this,
                android.R.layout.simple_list_item_multiple_choice,
                iniciales );

        lstvIniciales.setAdapter( adaptador );
    }

    //----------------------------------------------------------------------------------------------

    public void btnElementosSeleccionadosClick ( View v ) {
        seleccionados = new ArrayList<String>();

        SparseBooleanArray elementosMarcados = lstvIniciales.getCheckedItemPositions();

        for ( int i = 0; i < elementosMarcados.size(); i++ ) {
            int llave = elementosMarcados.keyAt( i );
            boolean valor = elementosMarcados.get( llave );

            if ( valor ) {
                seleccionados.add( lstvIniciales.getItemAtPosition( llave).toString() );
            }
        }

        if ( seleccionados.isEmpty() ) {
            Toast.makeText(this, "No hay elementos seleccionados", Toast.LENGTH_SHORT ).show();
        } else {
            Toast.makeText( this, "Iniciales: " + seleccionados, Toast.LENGTH_SHORT ).show();
        }
    }

    //----------------------------------------------------------------------------------------------
}












