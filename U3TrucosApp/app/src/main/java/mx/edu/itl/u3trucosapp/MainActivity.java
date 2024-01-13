package mx.edu.itl.u3trucosapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View layoutRaiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutRaiz = findViewById( R.id.layoutRaiz );
        layoutRaiz.setOnClickListener( this );
    }

    @Override
    public void onBackPressed() {
        // Desplegar un AlerDialog si se desea salir
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setMessage( "Desea Salir?" )
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish ();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss ();
                    }
                }).create().show();
    }

    @Override
    public void onClick( View view ) {
        // Truco de ocultar el teclado virtual
        View vista = getCurrentFocus();

        if ( vista != null ) {
            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE );
            imm.hideSoftInputFromWindow ( vista.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS );
        }
    }
}