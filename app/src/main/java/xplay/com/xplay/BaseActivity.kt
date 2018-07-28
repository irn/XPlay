package xplay.com.xplay

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    var cities : Map<String, Int> = mapOf(
            Pair("London", R.drawable.london), //lat: 51.544188 lon: -0.1834747
            Pair("Istambul", R.drawable.istanbul),
            Pair("Amsterdam", R.drawable.amsterdam),
            Pair("Berlin", R.drawable.berlin),
            Pair("Paris", R.drawable.paris)) //lat: 48.8552915 lon: 2.3600423


    lateinit var city : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (savedInstanceState == null && intent.hasExtra(SplashActivity.CITY_ARG)){
            city = intent.getStringExtra(SplashActivity.CITY_ARG)
        } else {
            city = savedInstanceState?.getString(SplashActivity.CITY_ARG) ?: ""
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(SplashActivity.CITY_ARG, city)
    }

    protected fun setCityDrawable(drawable : LayerDrawable, city : String){
        val resourceId = if (cities.containsKey(city))  cities.getValue(city) else cities.getValue("London")
        drawable.setDrawableByLayerId(R.id.layerCity, resources.getDrawable(resourceId))
    }

}