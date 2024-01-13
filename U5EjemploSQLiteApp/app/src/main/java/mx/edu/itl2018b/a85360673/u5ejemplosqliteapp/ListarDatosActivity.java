package mx.edu.itl2018b.a85360673.u5ejemplosqliteapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListarDatosActivity extends AppCompatActivity {

    private static final String TAG = "ListarDatosActivity";

    BaseDatosHelper mBaseDatosHelper;

    private ListView mListView;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.lista_layout );
        mListView = (ListView) findViewById ( R.id.listView );
        mBaseDatosHelper = new BaseDatosHelper (this );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onResume() {
        super.onResume();
        llenarListView();
    }

    //----------------------------------------------------------------------------------------------

    private void llenarListView() {
        Log.d(TAG, "llenarListView: Desplegando datos en el ListView.");

        // obtener los datos y llenar una lista (List)
        Cursor datos = mBaseDatosHelper.getDatos ();
        ArrayList<String> listDatos = new ArrayList<> ();
        while ( datos.moveToNext () ){
            // Obtener el valor desde la bd en la columna 1
            // luego agregarlo al  ArrayList
            listDatos.add ( datos.getString (1 ) );
        }
        // Crear un List Adapter y ponerlo como el Adapter
        ListAdapter adapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, listDatos );
        mListView.setAdapter ( adapter );

        // Establecer un onItemClickListener para el ListView
        mListView.setOnItemClickListener ( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nombre = adapterView.getItemAtPosition ( i ).toString ();
                Log.d ( TAG, "onItemClick: Ud hizo click en " + nombre );

                Cursor datos = mBaseDatosHelper.getItemID ( nombre ); // Obtener el ID asociado con ese nombre
                int itemID = -1;
                while ( datos.moveToNext () ) {
                    itemID = datos.getInt ( 0 );
                }
                if ( itemID > -1 ) {
                    Log.d ( TAG, "onItemClick: El ID es: " + itemID);
                    Intent editarDatosIntent = new Intent (ListarDatosActivity.this, EditarDatosActivity.class );
                    editarDatosIntent.putExtra ("id", itemID );
                    editarDatosIntent.putExtra ("nombre", nombre );
                    startActivity ( editarDatosIntent );
                }
                else {
                    mostrarToast ( "No existe un ID asociado a ese nombre" );
                }
            }
        } );
    }

    //----------------------------------------------------------------------------------------------

    private void mostrarToast ( String mensaje ) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------------------------------------
}
