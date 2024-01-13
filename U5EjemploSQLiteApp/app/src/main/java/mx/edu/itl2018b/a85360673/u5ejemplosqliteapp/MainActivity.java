package mx.edu.itl2018b.a85360673.u5ejemplosqliteapp;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    BaseDatosHelper mBaseDatosHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState   );
        setContentView ( R.layout.main_layout );
        editText = (EditText) findViewById ( R.id.editText );
        btnAdd = (Button) findViewById ( R.id.btnAdd );
        btnViewData = (Button) findViewById ( R.id.btnView );
        mBaseDatosHelper = new BaseDatosHelper (this );

        btnAdd.setOnClickListener ( new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                String newElemento = editText.getText().toString();
                if ( editText.length() != 0 ) {
                    AddDatos ( newElemento );
                    editText.setText ( "" );
                } else {
                    mostrarToast ( "El campo no puede quedar en blanco" );
                }

            }
        });

        btnViewData.setOnClickListener ( new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                Intent intent = new Intent (MainActivity.this, ListarDatosActivity.class );
                startActivity ( intent );
            }
        });

    }

    //----------------------------------------------------------------------------------------------

    public void AddDatos ( String newElemento ) {
        boolean insertDatos = mBaseDatosHelper.addDatos ( newElemento );

        if ( insertDatos ) {
            mostrarToast ("Datos agregados correctamente");
        } else {
            mostrarToast ("ERROR al agregar los datos" );
        }
    }

    //----------------------------------------------------------------------------------------------

    private void mostrarToast ( String mensaje ) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------------------------------------
}
