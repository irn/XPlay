package xplay.com.xplay

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.LayerDrawable
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    lateinit var locationProviderClient : FusedLocationProviderClient

    companion object {

        const val CITY_ARG = "com.xplay.CITY_ARG"
    }

    private var currentCity : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        locationProviderClient = LocationServices.getFusedLocationProviderClient(baseContext)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 0)
            }
        }

        imageView.postDelayed({
            val intent = Intent(baseContext, LoginActivity::class.java)
            intent.putExtra(CITY_ARG, currentCity)
            startActivity(intent) }, 3000)

        getLocation()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        getLocation()
    }

    fun getLocation() {
        locationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            val geocoder = Geocoder(baseContext)
            if (location != null) {
                val fromLocation = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                currentCity = fromLocation[0].locality
                Log.i("-------------", "The current location city is ${currentCity}")
                setCityDrawable(constraintLayout.background as LayerDrawable, currentCity)

            }
        }
    }
}
