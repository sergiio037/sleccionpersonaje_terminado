package com.example.sleccionpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.sleccionpersonaje.databinding.ActivityMercaderBinding

class ActivityMercader : AppCompatActivity() {
    lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.textComerciar.setOnClickListener(){
            binding.botonesMercader.isVisible=true
        }
        binding.spinnerCantidad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                    this@ActivityMercader,
                    getString(R.string.selected_item) + " " + personNames[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }

    }
}