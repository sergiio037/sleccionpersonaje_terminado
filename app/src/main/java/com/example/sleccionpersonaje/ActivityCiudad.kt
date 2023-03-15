package com.example.sleccionpersonaje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sleccionpersonaje.databinding.ActivityCiudadBinding
import com.example.sleccionpersonaje.databinding.ActivityMercaderBinding
import kotlin.random.Random

class ActivityCiudad : AppCompatActivity() {
    lateinit var binding: ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent_objeto = Intent(this,Activity_objeto::class.java)
        val intent_aleatorio = Intent(this,Aleatorizador_de_eventos::class.java)
        val intent_enemigo = Intent(this,Combate::class.java)
        val intent_mercader = Intent(this,ActivityMercader::class.java)
        var random_intent:String
        binding.entrar.setOnClickListener(){

            ciudad=true
            random_intent= ActivityCiudad.getRandomIntent()

            if (random_intent.equals("Mercader"))
                startActivity(intent_mercader)
            else if (random_intent.equals("Objeto"))
                startActivity(intent_objeto)
            else if (random_intent.equals("Enemigo"))
                startActivity(intent_enemigo)
        }
        binding.continuar.setOnClickListener() {
            startActivity(intent_aleatorio)
        }
    }
    companion object{
        var enemigos=0
        var ciudad=false
        fun calculo():Boolean{

            if (enemigos==5){
                enemigos=0
                ciudad=false
                return true
            }
            return !ciudad
        }
        fun getRandomIntent(): String {
            val strings = arrayOf("Mercader","Objeto","Enemigo")
            val randomValue = Random.nextInt(strings.size)
            return strings.get(randomValue)

        }
    }
}