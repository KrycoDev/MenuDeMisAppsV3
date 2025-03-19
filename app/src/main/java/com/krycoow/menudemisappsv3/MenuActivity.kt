package com.krycoow.menudemisappsv3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.krycoow.menudemisappsv3.imccalculator.ImcCalculatorActivity
import com.krycoow.menudemisappsv3.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Encontrar el botón por su ID
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)


        // Configurar el listener para el botón
        btnSaludApp.setOnClickListener {
            navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateTOIMCApp() }
        btnTODO.setOnClickListener { navigateTODOApp() }
    }

    private fun navigateTODOApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)

    }

    private fun navigateTOIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)

    }

    // Función para navegar a la siguiente actividad
    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}
