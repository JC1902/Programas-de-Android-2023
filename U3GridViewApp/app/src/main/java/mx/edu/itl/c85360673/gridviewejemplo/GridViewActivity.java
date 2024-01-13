package mx.edu.itl.c85360673.gridviewejemplo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

// ---> import com.bumptech.glide.Glide;


public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    final Integer [] companias = { R.drawable.ea, R.drawable.obsidian,
                                   R.drawable.activision, R.drawable.pokemon_company,
                                   R.drawable.atari, R.drawable.devolver,
                                   R.drawable.rare, R.drawable.game_freak };

    private GridView grdvCompanias;
    private GridAdaptador  adaptador;

    //------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_grid_view);

        // Crear el Adapter y establecerlo como adapter en el GridView
        grdvCompanias = findViewById( R.id.grdvCompanias );
        adaptador = new GridAdaptador ( this, R.layout.gridview_item_imagen, companias );
        grdvCompanias.setAdapter( adaptador );

        grdvCompanias.setOnItemClickListener( this );
    }

    //------------------------------------------------------------------------------------------

    @Override
    public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l ) {
        Intent intent = new Intent( this, GridViewDetalleActivity.class );

        // Pasamos como argumento al otro activity el ID del recurso drawable del escudo seleccionado
        intent.putExtra ( "compania", companias[ i ] );
        startActivity ( intent );
    }

    //------------------------------------------------------------------------------------------

    public class GridAdaptador extends ArrayAdapter {
        private Integer [] logos;
        private int        layoutResId;
        private LayoutInflater inflater;

        //------------------------------------------------------------------------------------------
        // Constructor

        public GridAdaptador(@NonNull Context context, int resource, @NonNull Integer [] logos) {
            // Llamar al constructor de la clase padre y guardar los argumentos en variables de la clase
            super( context, resource, logos );

            this.logos = logos;
            layoutResId = resource;
            inflater = LayoutInflater.from( context );
        }

        //------------------------------------------------------------------------------------------

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Implementar la personalizacion de convertView inflando primero el layout que va a utilizar
            if ( convertView == null ) {
                convertView = inflater.inflate( layoutResId, parent, false );
            }

            ImageView imgLogos = convertView.findViewById( R.id.imgvLogo );
            imgLogos.setScaleType( ImageView.ScaleType.FIT_XY );

            Glide.with( imgLogos.getContext() ).load( companias [ position ] ).into( imgLogos );

            return convertView;
        }

        //------------------------------------------------------------------------------------------
    }
}
