package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.appcompat.app.AppCompatActivity;
import modelo.Pokemon;
import modelo.SpinnerPokemonsAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerPersonalizadoActivity extends AppCompatActivity {

    private Spinner spnPokemons;
    private ArrayList<Pokemon> pokemons;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_personalizado);

        spnPokemons = findViewById ( R.id.spnClubes );

        // Inicializar el ArrayList de clubes
        inicializarClubes ();

        // Crear el adapter del tipo SpinnerClubesAdapter y establecer el layout con  setDropDownViewResource ()
        SpinnerPokemonsAdapter adaptador = new SpinnerPokemonsAdapter( this, pokemons );
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        // Establecer el adaptador para el spinner
        spnPokemons.setAdapter( adaptador );


    }

    //----------------------------------------------------------------------------------------------

    private void inicializarClubes () {
        pokemons = new ArrayList<> ( );
        // Agregar elementos al ArrayList
        pokemons.add( new Pokemon( "Sylveon", R.drawable.sylveon ) );
        pokemons.add( new Pokemon( "Chandelure", R.drawable.chandelure ) );
        pokemons.add( new Pokemon( "Rhyperior", R.drawable.rhyperior ) );
        pokemons.add( new Pokemon( "Butterfree", R.drawable.butterfree ) );
        pokemons.add( new Pokemon( "Goodra", R.drawable.goodra ) );
    }

    //----------------------------------------------------------------------------------------------

    public  void btnAceptarClick ( View v ) {
         // Recuperar el elemento seleccionado del Spinner y mostrar el nombre del club en un Toast
        Pokemon pokemon = ( Pokemon )spnPokemons.getSelectedItem();


        Toast.makeText(this, "Pokemon seleccionado: " + pokemon.getNombre()
                , Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------------------------------------
}
