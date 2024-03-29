package util.imagenes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Imagen {

    public static Bitmap reducirBitmap (Context context, String strUri, int maxAncho, int maxAlto ) {
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options ();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream  ( context.getContentResolver()
                                                 .openInputStream ( Uri.parse (  strUri ) ),
                               null,
                                         options );

            options.inSampleSize = (int) Math.max (
                    Math.ceil ( options.outWidth / maxAncho ),
                    Math.ceil ( options.outHeight / maxAlto )
            );
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream ( context.getContentResolver()
                                                       .openInputStream ( Uri.parse ( strUri ) ),
                                                null,
                                                 options );
        } catch ( FileNotFoundException ex ) {
            Toast.makeText ( context, "Archivo no encontrado.", Toast.LENGTH_LONG ).show ();
            ex.printStackTrace ();
            return null;
        } catch (IOException ex) {
            Toast.makeText(context, "Error de E/S al leer la imagen.", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
            return null;
        }
    }
}
