/***************************************************************************************************
                PlaceArFragment.kt Última modificación: 18/Noviembre/2023
***************************************************************************************************/

package mx.edu.itl.polarisapp.ar


import com.google.ar.sceneform.ux.ArFragment

class PlacesArFragment : ArFragment () {

    //----------------------------------------------------------------------------------------------

    override fun getAdditionalPermissions(): Array<String> {
        return arrayOf( android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        android.Manifest.permission.ACCESS_FINE_LOCATION )
    }

    //----------------------------------------------------------------------------------------------

}