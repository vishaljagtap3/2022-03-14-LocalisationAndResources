package com.aavidsoft.resourcesandlocalization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aavidsoft.resourcesandlocalization.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mt("onCreate : DemoActivity")

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //if(intent.hasExtra("data")) {
        if(intent.hasExtra("path")) {
            /*Toast.makeText(this,
                "${intent.getLongExtra("data", -1)}",
                Toast.LENGTH_LONG
            ).show()*/
            mt("${intent.getStringExtra("path")}")
        }

        binding.btnStartDemoAct.setOnClickListener {
            var intent = Intent(this, DemoActivity::class.java)
            intent.putExtra("data", System.currentTimeMillis())
            intent.putExtra("path", binding.edtPath.text.toString())
            startActivity(intent)
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        mt("Playing... ${intent?.getStringExtra("path")}")
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}