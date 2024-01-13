package mx.edu.itl2018b.a85360673.u5ejemplosqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDatosHelper extends SQLiteOpenHelper {

    private static final String TAG = "BaseDatosHelper";

    private static final String DB_NAME    = "personitasDB";
    private static final int    DB_VERSION = 1;
    private static final String TABLE_NAME = "personas_tabla";
    private static final String COL1 = "ID";
    private static final String COL2 = "nombre";

    //----------------------------------------------------------------------------------------------

    public BaseDatosHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTabla = "CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT )";
        db.execSQL ( crearTabla );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onUpgrade ( SQLiteDatabase db, int i, int i1 ) {
        db.execSQL ( "DROP IF TABLE EXISTS " + TABLE_NAME );
        onCreate ( db );
    }

    //----------------------------------------------------------------------------------------------

    public boolean addDatos ( String item ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        Log.d(TAG, "addDatos: Agregando " + item + " a " + TABLE_NAME);

        long resultado = db.insert(TABLE_NAME, null, contentValues);

        // si se insertó correctamente resultado valdrá -1
        if ( resultado == -1 ) {
            return false;
        } else {
            return true;
        }
    }

    //----------------------------------------------------------------------------------------------

    public Cursor getDatos () {
        // getReadableDatabase () y getWritableDatabase () devuelven el mismo objeto
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery ( query, null );
        return data;
    }

    //----------------------------------------------------------------------------------------------

    public Cursor getItemID ( String nombre ) {
        SQLiteDatabase db = this.getReadableDatabase ();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + nombre + "'";
        Cursor data = db.rawQuery ( query, null );
        return data;
    }

    //----------------------------------------------------------------------------------------------

    public void updateNombre ( String newNombre, int id, String oldNombre ) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newNombre + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldNombre + "'";
        Log.d ( TAG, "updateName: query: " + query );
        Log.d ( TAG, "updateName: Setting name to " + newNombre );
        db.execSQL ( query );
    }

    //----------------------------------------------------------------------------------------------

    public void deleteNombre ( int id, String nombre ){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + nombre + "'";
        Log.d ( TAG, "deleteNombre: query: " + query );
        Log.d ( TAG, "deleteNombre: Eliminando " + nombre + " de la base de datos.");
        db.execSQL(query);
    }

    //----------------------------------------------------------------------------------------------
}
























