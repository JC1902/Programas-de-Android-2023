package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerSimpleActivity extends AppCompatActivity {

    Spinner spnPokemons;
    String [] pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);

        // Se obtiene la referencia del spinner en el layout
        spnPokemons = findViewById ( R.id.spnClubesLigaMx );

        // Crear un adaptador ArrayAdapter desde un recurso R.array usando createFromResource ()
        // El 3er argumento es un tipo de TextView. En el simple_spinner_item los elementos salen pegaditos
        ArrayAdapter adaptador = ArrayAdapter.createFromResource( this,
                R.array.pokemons_varios,
                android.R.layout.simple_spinner_item );

        // En el adaptador se cambiar la vista que se usa para mostrar los elementos con setDropDownViewResource ().
        // En un simple_spinner_dropdown_item  los elementos salen mas separados.
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        // Se establece el adaptador en el spinner
        spnPokemons.setAdapter( adaptador );

        pokemon = getResources().getStringArray( R.array.pokemons_varios );

        // Se establece un listener del spinner para los eventos onItemSeelected
        spnPokemons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 3 distintas formas de obtener el elemento seleccionado
                String s1 = adapterView.getItemAtPosition( i ).toString();
                String s2 = ( (TextView) view ).getText().toString();
                String s3 = pokemon[ i ];

                Toast.makeText(SpinnerSimpleActivity.this,  s1 + ", " + s2 + ", " + s3
                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
