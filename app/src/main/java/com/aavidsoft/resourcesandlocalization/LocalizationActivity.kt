package com.aavidsoft.resourcesandlocalization

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aavidsoft.resourcesandlocalization.databinding.LocalizationActivityBinding

class LocalizationActivity : AppCompatActivity() {

    lateinit var binding: LocalizationActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mt("onCreate")
        if(savedInstanceState != null) {
            //load the data back
        }

        var config = resources.configuration

        binding = LocalizationActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetMessage.setOnClickListener {
            binding.txtMessage.setText(binding.edtMessage.text.toString())
        }

        //var message = lastCustomNonConfigurationInstance as String?
        var data = lastCustomNonConfigurationInstance as Data?
        /*if(message != null) {
            mt("Got the data back...")
            binding.txtMessage.setText(message!!)
        }*/
        if(data != null) {
            binding.txtMessage.setText("${data.message} -- ${data.time}")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mt("onConfigurationChanged")

        if(newConfig.touchscreen == Configuration.TOUCHSCREEN_FINGER) {
            mt("touch screen device")
        }
        if(newConfig.keyboard == Configuration.KEYBOARD_NOKEYS) {
            mt("touch screen")
        }

    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        mt("onRetain")
        //return binding.txtMessage.text
        return Data(binding.edtMessage.text.toString(), System.currentTimeMillis())
    }

    override fun onDestroy() {
        mt("onDestroy")
        super.onDestroy()
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

}