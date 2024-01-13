/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                       Clase de elementos personalizada
:*
:*  Archivo     : ItemModelActivity.java
:*  Autor       : Jorge Cisneros de la Torre     20130789
:*  Fecha       : 26/Oct/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripción : Clase que permite que el ListView pueda contener imagenes y texto
                  en un mismo elemento de la lista
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3entrenamientoapp;

//--------------------------------------------------------------------------------------------------

public class ItemModel {
    int imagenResource; // ID de recurso de la imagen
    String texto;

    //----------------------------------------------------------------------------------------------

    public ItemModel( int recursoImg, String texto ) {
        this.imagenResource = recursoImg;
        this.texto = texto;
    }

    //----------------------------------------------------------------------------------------------

    public int getRecursoImg () {
        return imagenResource;
    }

    //----------------------------------------------------------------------------------------------

    public String getTexto () {
        return texto;
    }
}
