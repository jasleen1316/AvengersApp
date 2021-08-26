package com.jasleen.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MessageActivity : AppCompatActivity() {
    var messageTBD: String? = "Null"
    lateinit var txtYourMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        title = "Your Message"

        txtYourMessage = findViewById(R.id.txtYourMessage)

        if(intent != null){
            messageTBD = intent.getStringExtra("Message")

        }
        else {
            Toast.makeText(
                this@MessageActivity,
                "No message was sent",
                Toast.LENGTH_LONG
            ).show()
        }

        txtYourMessage.text = messageTBD



    }

}