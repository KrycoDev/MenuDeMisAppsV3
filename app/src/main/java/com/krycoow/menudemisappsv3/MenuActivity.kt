package com.krycoow.menudemisappsv3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnCalcuImc = findViewById<Button>(R.id.btnCalcuImc)
        btnCalcuImc.setOnClickListener {  }
    }

    fun navigateToCalcuIMC(){
        val intent = Intent(this)


    }

}