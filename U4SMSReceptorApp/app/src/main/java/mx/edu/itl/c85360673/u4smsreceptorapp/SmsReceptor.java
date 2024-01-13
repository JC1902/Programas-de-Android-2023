package mx.edu.itl.c85360673.u4smsreceptorapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceptor extends BroadcastReceiver {
    private MainActivity mainActivity;

    public SmsReceptor ( MainActivity mainActivity ) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive( Context context, Intent intent ) {
        SmsMessage smsMensajes [] = Telephony.Sms.Intents.getMessagesFromIntent( intent );

        if ( smsMensajes != null ) {
            SmsMessage sms = smsMensajes[ 0 ];
            String telef = sms.getOriginatingAddress();
            String texto = sms.getMessageBody();

            Calendar c = Calendar.getInstance();
            c.setTimeInMillis( sms.getTimestampMillis() );
            String fechaHora = c.getTime().toString();

            mainActivity.actualizarSmsTextView(
                    "SMS:\n" +
                    "Fecha y hora: " + fechaHora + "\n" +
                    "Enviado por: " + telef + "\n" +
                    "Mensaje: " + texto
            );

            Toast.makeText( context,
                            "SMS: (" + fechaHora + ")\n" + telef + "\n" + texto,
                            Toast.LENGTH_SHORT ).show();
        }
    }
}
