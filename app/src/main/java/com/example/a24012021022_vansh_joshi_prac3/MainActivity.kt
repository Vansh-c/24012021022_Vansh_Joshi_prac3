package com.example.a24012021022_vansh_joshi_prac3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        implicitIntent()
//        explicitIntent()
    }

    fun implicitIntent(){
      findViewById<Button>(R.id.btn_browse).setOnClickListener {
          Intent(
              Intent.ACTION_VIEW,
              Uri.parse(findViewById<EditText>(R.id.editTextText).text.toString())
          ).also {
              startActivity(it)
          }
      }

        // fun implicitIntent{Intent(Intent.Action_Viewwhat action? , Uri.parse(url) -> action is performed on what data ,
           // .also{(startActivity(it)} }   => it means launch this activity as per intent .

        findViewById<Button>(R.id.btn_call).setOnClickListener {
            val number = findViewById<EditText>(R.id.editTextText2).text.toString()
            val i = Intent(Intent.ACTION_DIAL)
            i.setData("tel:$number".toUri())
            startActivity(i)
        }

        findViewById<Button>(R.id.btn_call_log).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply { startActivity(this) }
        }  // setType tells what data I am interested to work with. if intent.setType((CallLog.Calls.CONTENT_TYPE)  is refers to inbuilt call log .
           // apply means telling Intent to do something with it .

        findViewById<Button>(R.id.btn_gallery).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").apply{startActivity(this)}
        }

        findViewById<Button>(R.id.btn_camera).setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }

        findViewById<Button>(R.id.btn_alarm).setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }

        findViewById<Button>(R.id.btn_browse).setOnClickListener {
        }







    }

    fun explicitIntent(){
       Intent(this@MainActivity, LoginActivity::class.java).also { startActivity(it) }
        // it means from @MainActivity open LoginActivity.
    }
}