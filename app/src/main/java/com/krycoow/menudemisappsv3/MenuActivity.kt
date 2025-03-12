package com.krycoow.menudemisappsv3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Encontrar el botón por su ID
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)

        // Configurar el listener para el botón
        btnSaludApp.setOnClickListener {
            navigateToSaludApp()
        }
    }

    // Función para navegar a la siguiente actividad
    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}
