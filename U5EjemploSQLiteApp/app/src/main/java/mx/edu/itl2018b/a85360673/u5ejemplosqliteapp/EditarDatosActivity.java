package mx.edu.itl2018b.a85360673.u5ejemplosqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class EditarDatosActivity extends AppCompatActivity {

    private static final String TAG = "EditarDatosActivity";

    private Button btnGuardar, btnEliminar;
    private EditText editable_item;

    BaseDatosHelper mBaseDatosHelper;

    private String selectedNombre;
    private int selectedID;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate ( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_datos_layout);
        btnGuardar = (Button) findViewById(R.id.btnSave);
        btnEliminar = (Button) findViewById(R.id.btnDelete);
        editable_item = (EditText) findViewById(R.id.editable_item);
        mBaseDatosHelper = new BaseDatosHelper (this );

        //Obtenet el intent que invocó a este Activity
        Intent intentRecibido = getIntent();

        // obtener el ID que se pasó como un extra
        selectedID = intentRecibido.getIntExtra ("id",-1 ); // NOTA: -1 es el valor de default

        //obtener el nombre que se pasó como un extra
        selectedNombre = intentRecibido.getStringExtra ("nombre" );

        //establecer el texto para mostrar el nombre seleccionado actualmente
        editable_item.setText ( selectedNombre );

        btnGuardar.setOnClickListener ( new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {
                String item = editable_item.getText().toString();
                if ( !item.equals ( "" ) ) {
                    mBaseDatosHelper.updateNombre ( item, selectedID, selectedNombre );
                } else {
                    mostrarToast ("Debe teclear un nombre" );
                }
            }
        } );

        btnEliminar.setOnClickListener ( new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {
                mBaseDatosHelper.deleteNombre ( selectedID, selectedNombre );
                editable_item.setText ( "" );
                mostrarToast ( "Eliminado de la base de datos" );
            }
        });

    }

    //----------------------------------------------------------------------------------------------

    private void mostrarToast ( String mensaje ) {
        Toast.makeText (this, mensaje, Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------
}
























