package modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import mx.edu.itl.c85360673.u3spinnerejemploapp.R;

public class SpinnerPokemonsAdapter extends ArrayAdapter<Pokemon> {

    //----------------------------------------------------------------------------------------------
    // Constructor

    public SpinnerPokemonsAdapter(@NonNull Context context, ArrayList<Pokemon> clubes ) {
        super ( context, 0, clubes );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    @Override
    public View getDropDownView ( int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    //----------------------------------------------------------------------------------------------
    // Metodo personalizado para inicializar la vista del elemento dado por el argumento position

    private View inicializarView ( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        // Configurar el View llamado convertView para inflar  spinner_fila_imagen_texto  y
        // establecer la imagen del logo del club y el nombre del club en el layout.
        if ( convertView == null ) {
            convertView = LayoutInflater.from( getContext() )
                    .inflate(R.layout.spinner_fila_imagen_texto, parent, false );

        }

        ImageView sprite = convertView.findViewById( R.id.imgvPokemon );
        TextView nombre = convertView.findViewById( R.id.txtvNombre );

        Pokemon pokemon = getItem( position );

        sprite.setImageResource ( pokemon.getSpriteID() );
        nombre.setText ( pokemon.getNombre() );

        return convertView;
    }

    //----------------------------------------------------------------------------------------------
}
