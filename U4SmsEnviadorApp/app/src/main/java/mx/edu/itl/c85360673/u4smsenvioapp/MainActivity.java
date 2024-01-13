package mx.edu.itl.c85360673.u4smsenvioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtTelefonoDestino;
    private EditText edtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefonoDestino = findViewById ( R.id.edtTelefonoDestino );
        edtMensaje         = findViewById ( R.id.edtMensaje         );
    }

    public void btnEnviarClick ( View v ) {
        if ( validarDatos() == false )
            return;

        SmsManager smsMgr = SmsManager.getDefault ();

        smsMgr.sendTextMessage( edtTelefonoDestino.getText().toString(),
                                null,
                                edtMensaje.getText().toString(),
                                null,
                                null );
        Toast.makeText( this, "SMS Enviado", Toast.LENGTH_SHORT ).show();
        edtMensaje.setText( "" );
    }

    private boolean validarDatos () {
        if ( edtTelefonoDestino.getText().toString().isEmpty() ) {
            edtTelefonoDestino.setError( "Telefono destino no puede ser vacío" );
            return false;
        }

        if ( edtMensaje.getText().toString().isEmpty() ) {
            edtMensaje.setError( "Escriba el mensaje a enivar" );
            return false;
        }

        return true;
    }

    public void fabAcercaDe ( View v ) {
        Intent intent = new Intent( MainActivity.this, AcercaDeActivity.class );
        startActivity( intent );
    }

}
