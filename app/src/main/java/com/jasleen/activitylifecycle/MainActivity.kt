package com.jasleen.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    var txtSignUp: TextView? = null
    var txtForgotPwd: TextView? = null
    val validMobileNumber = "123"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_new)

        if(isLoggedIn) {
            val intent = Intent(this@MainActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
//        else{
//        setContentView(R.layout.activity_new)
//        }
        title = "Log In"


        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtSignUp = findViewById(R.id.txtSignUp)
        txtForgotPwd = findViewById(R.id.txtForgotPwd)


        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avenger"

            if(validMobileNumber==mobileNumber){
                val intent = Intent(this@MainActivity, AvengersActivity::class.java)

                if(password == validPassword[0]){
                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
                else if(password == validPassword[1]){
                    nameOfAvenger = "Captain America"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)

                }
                else if(password == validPassword[2]){
                    nameOfAvenger = "Hulk"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)

                }
                else if(password == validPassword[3]){
                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)

                }

            }
            else{
                Toast.makeText(
                    this@MainActivity,
                    "invalid username or password",
                    Toast.LENGTH_LONG ).show()
            }
        }


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onPause(){
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()

    }

}