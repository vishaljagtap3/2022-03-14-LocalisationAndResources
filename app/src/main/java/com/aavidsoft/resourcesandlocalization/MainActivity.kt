package com.aavidsoft.resourcesandlocalization

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aavidsoft.resourcesandlocalization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var appName : String = resources.getString(R.string.app_name)
        var code = resources.getInteger(R.integer.code)
        var bgColor = resources.getColor(R.color.bgColor)
        var drawable : Drawable = resources.getDrawable(R.mipmap.ic_launcher)
        var isPassword = resources.getBoolean(R.bool.is_password)
        var normalWidth = resources.getDimension(R.dimen.normal_width)

        binding.img.setImageDrawable(drawable)

        Log.e("tag", "$appName $code $bgColor $isPassword $normalWidth")

        var cityCodes = resources.getIntArray(R.array.city_codes)
        var cities = resources.getStringArray(R.array.city_names)
        for(cityCode in cityCodes) {
            Log.e("tag", "${cityCode}")
        }

        for(cityName in cities) {
            Log.e("tag", "${cityName}")
        }

    }
}