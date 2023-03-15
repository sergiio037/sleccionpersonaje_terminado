package com.example.sleccionpersonaje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sleccionpersonaje.databinding.ActivityCombateBinding
import com.example.sleccionpersonaje.databinding.ActivityDeadBinding
import com.example.sleccionpersonaje.databinding.ActivityMainBinding

class Dead : AppCompatActivity() {
    lateinit var binding: ActivityDeadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent_r=Intent(this,MainActivity::class.java)
        binding.buttonReinicio.setOnClickListener(){
            startActivity(intent_r)
        }
    }
}