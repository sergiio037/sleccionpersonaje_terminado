package com.example.sleccionpersonaje

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sleccionpersonaje.databinding.ActivityAleatorizadorDeEventosBinding
import com.example.sleccionpersonaje.databinding.ActivityResumenBinding
import kotlin.random.Random

class Aleatorizador_de_eventos : AppCompatActivity() {
    lateinit var binding: ActivityAleatorizadorDeEventosBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAleatorizadorDeEventosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent_objeto =Intent(this,Activity_objeto::class.java)
        val intent_ciudad =Intent(this,ActivityCiudad::class.java)
        val intent_enemigo =Intent(this,Combate::class.java)
        val intent_mercader =Intent(this,ActivityMercader::class.java)
        var random = ""
        binding.buttonDado.setOnClickListener(){


             Handler().postDelayed({
                random=getRandomIntent()
                if (random.equals("Ciudad"))
                    startActivity(intent_ciudad)
                else if (random.equals("Mercader"))
                    startActivity(intent_mercader)
                else if (random.equals("Objeto"))
                    startActivity(intent_objeto)
                else if (random.equals("Enemigo"))
                    startActivity(intent_enemigo)
            }, 10)
        }
    }
    fun getRandomIntent(): String {
        val strings = arrayOf("Mercader","Objeto","Ciudad","Enemigo")
        val randomValue = Random.nextInt(strings.size)
        return strings.get(randomValue)
    }
}