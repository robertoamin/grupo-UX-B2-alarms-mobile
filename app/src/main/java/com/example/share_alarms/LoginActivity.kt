package com.example.share_alarms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.example.share_alarms.HomeActivity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun onLoginButtonClick(view: View) {
        // Agrega aquí la lógica de autenticación, si es necesario.

        // Luego, inicia la actividad HomeActivity.
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}