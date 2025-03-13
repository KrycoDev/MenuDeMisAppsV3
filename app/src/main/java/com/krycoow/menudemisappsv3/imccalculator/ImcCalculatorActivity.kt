package com.krycoow.menudemisappsv3.imccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.krycoow.menudemisappsv3.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = true


    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()

    }




    private fun initComponents() {

        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)

    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            setGenderColor()
            changeGender()
        }

        viewFemale.setOnClickListener {
            setGenderColor()
            changeGender()
        }

    }

    private fun changeGender(){

       isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun setGenderColor(){

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))


    }

    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int{

        val colorReference = if (isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)

    }

    private fun initUI() {

        setGenderColor()

    }

}