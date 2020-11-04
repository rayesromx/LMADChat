package com.fcfm.poi.plantilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Oculta el teclado para que no se abra automaticamente al iniciar el activity si esta presente un editText
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        btnLogin.setOnClickListener {
             startActivity(Intent(this, HomeActivity::class.java))
        }

        btnSignup.setOnClickListener {

            startActivity(Intent(this, RegisterActivity::class.java))
        }


    }

}