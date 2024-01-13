package mx.edu.itl.c85360673.u3listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaTextoImagenActivity extends AppCompatActivity {

    private ListView lstvClubes;

    private final String [] clubes        = { "Blastoise", "Charizard", "Ivysaur", "Milotic",
                                              "Gigalith" };
    private final String [] descripciones = { "Primera Generación" ,
                                            "Primera Generación",
                                            "Primera Generación",
                                            "Tercera Generación",
                                            "Quinta Generación"
                                          };
    private final int [] logos = { R.drawable.blastoise,
                                   R.drawable.charizard,
                                   R.drawable.ivysaur,
                                   R.drawable.milotic,
                                   R.drawable.gigalith
                                 };

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_texto_imagen);

        lstvClubes = findViewById  ( R.id.lstvSprites );

        // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador
        MiAdaptador adaptador = new MiAdaptador( this, clubes, descripciones, logos );
        lstvClubes.setAdapter( adaptador );

        // Establecemos un listener para el evento onItemClick del ListView
        lstvClubes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( ListaTextoImagenActivity.this, descripciones[ i ], Toast.LENGTH_SHORT).show();
            }
        });

    }



    //----------------------------------------------------------------------------------------------

    class MiAdaptador extends ArrayAdapter {
        private Context contexto;
        private String [] clubes;
        private String [] descripciones;
        private int [] logos;

        public MiAdaptador ( Context c, String [] clubes, String [] descripciones, int [] logos ) {
            super ( c, R.layout.list_fila_texto_imagen, R.id.txtTitulo, clubes );
            contexto = c;
            this.clubes = clubes;
            this.descripciones = descripciones;
            this.logos = logos;
        }

        @NonNull
        @Override
        public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
            if ( convertView == null ) {
                LayoutInflater layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // LayoutInflater.from ( context );

                convertView = layoutInflater.inflate(R.layout.list_fila_texto_imagen, parent, false);

            }

            ImageView imgLogo = convertView.findViewById( R.id.imgvLogo );
            TextView txtTitulo = convertView.findViewById( R.id.txtTitulo );
            TextView txtSubtitulo= convertView.findViewById( R.id.txtSubtitulo );

            imgLogo.setImageResource( logos[ position ] );
            txtTitulo.setText( clubes[ position ] );
            txtSubtitulo.setText( descripciones[ position ] );

            return convertView;
        }
    }
}
