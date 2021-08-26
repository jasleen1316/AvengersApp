package com.jasleen.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"

    lateinit var etMessage: EditText
    lateinit var btnSend: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)
        titleName = sharedPreferences.getString("Title", "The Avengers") // the second parameter is just the default value we want the n"Title key to have
        title = titleName

//        if(intent != null){
//            titleName = intent.getStringExtra("Name")
//        }




        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnSend.setOnClickListener{
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)

            val message = etMessage.text.toString()
            intent.putExtra("Message", message)

            startActivity(intent)
        }



    }

    fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

} 