package mx.edu.itl.c85360673.u4smsreceptorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView smsTextView;
    private SmsReceptor smsReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        smsTextView = findViewById(R.id.smsTextView);
        smsReceptor = new SmsReceptor(this);
        IntentFilter intentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(smsReceptor, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver( smsReceptor );
    }

    // Método para actualizar el TextView con el nuevo mensaje
    public void actualizarSmsTextView ( String mensaje ) {
        String textoActual = smsTextView.getText().toString();
        String nuevotexto = textoActual + "\n" + mensaje;
        smsTextView.setText( nuevotexto );
    }

    public void fabAcercaDe ( View v ) {
        Intent intent = new Intent( MainActivity.this, AcercaDeActivity.class );
        startActivity( intent );
    }
}
