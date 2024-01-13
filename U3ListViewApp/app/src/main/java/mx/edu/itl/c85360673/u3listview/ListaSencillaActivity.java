package mx.edu.itl.c85360673.u3listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaSencillaActivity extends AppCompatActivity {

    private final String [] pokemon = { "Timburr", "Golem", "Umbreon", "Chandelure", "Pikachu"
                                        , "Dragapult", "Bagon", "Glaceon", "Machamp", "Mew" };
    private final String [] tipo = { "Lucha", "Roca", "Siniestro", "Fantasma,Fuego", "Eléctrico"
                                     , "Fantasma, Dragón", "Dragón", "Hielo", "Lucha", "Psiquíco" };

    private TextView txtvResultado;
    private ListView lstvlPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sencilla);

        txtvResultado = findViewById ( R.id.txtvResultado );
        lstvlPokemon = findViewById ( R.id.lstvPokemon );

        // Se crea un ArrayAdapter: El 2o argumento debe ser el id de un recurso TEXTVIEW
        //                          El 3er argumento es la lista de Strings con los que se va a llenar
        ArrayAdapter adaptador = new ArrayAdapter( this, R.layout.list_fila_sencilla, pokemon );
        lstvlPokemon.setAdapter( adaptador );

        // Establecemos el listener para el evento OnItemClick  del ListView
        lstvlPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtvResultado.setText( "El pokemón " + lstvlPokemon.getItemAtPosition( i )
                                       + " es de tipo " + tipo [ i ] );

                String pokemon = ( ( TextView ) view ).getText().toString();
                Toast.makeText( ListaSencillaActivity.this, pokemon, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
