/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                       Clase del adaptador personalizado
:*
:*  Archivo     : CustomListAdapterActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 26/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase del adaptador personalizado que hace uso de la clase de
                  ItemModel para permitir que se vean las imagenes y el texto
                  con el diseño que se creo (item_lista.xml)
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3entrenamientoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//--------------------------------------------------------------------------------------------------

public class CustomListAdapter extends BaseAdapter  {

    Context context;
    List<ItemModel> items;
    LayoutInflater inflador;

    //----------------------------------------------------------------------------------------------

    public CustomListAdapter ( Context contexto, List<ItemModel> elementos ) {
        this.context = contexto;
        this.items = elementos;
        // inflamos con el contexto que se pase al constructor
        inflador = LayoutInflater.from( contexto );
    }

    //----------------------------------------------------------------------------------------------

    // Tamaño de la lista
    @Override
    public int getCount() {
        return items.size ();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public Object getItem( int position ) {
        return items.get( position );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public long getItemId( int position ) {
        return position;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        View view = convertView;

        // Obtener el diseño de los elementos de la lista
        if ( view == null ) {
            view = LayoutInflater.from( context ).inflate( R.layout.item_lista, parent, false );
        }

        // Obtener las imagenes y texto
        ImageView imageView = view.findViewById( R.id.imagen );
        TextView textView = view.findViewById( R.id.texto );

        ItemModel item = items.get( position );

        // Colocar la imagen y texto específico para cada elemento de la lista
        imageView.setImageResource( item.getRecursoImg() );
        textView.setText( item.getTexto() );

        return view;
    }

    //----------------------------------------------------------------------------------------------

}
