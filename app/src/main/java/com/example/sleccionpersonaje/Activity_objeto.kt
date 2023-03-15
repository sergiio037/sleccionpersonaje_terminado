package com.example.sleccionpersonaje

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.sleccionpersonaje.databinding.ActivityMainBinding
import com.example.sleccionpersonaje.databinding.ActivityObjetoBinding
import kotlin.random.Random

class Activity_objeto : AppCompatActivity() {

    lateinit var binding: ActivityObjetoBinding
    val cuchillo = Objeto(5,10,"cuchillo",0)
    val espada = Objeto(5,10,"espada",0)
    val escudo = Objeto(5,10,"escudo",0)
    val daga = Objeto(5,10,"daga",0)
    val cunai = Objeto(5,10,"cunai",0)
    val shuriken = Objeto(5,10,"shuriken",0)
    val lanza = Objeto(5,10,"lanza",0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var random = imagenRandom()
        val intent_objeto = Intent(this,Activity_objeto::class.java)
        val intent_enemigo = Intent(this,Combate::class.java)
        val intent_mercader = Intent(this,ActivityMercader::class.java)
        val intent_aleatorizador = Intent(this,Aleatorizador_de_eventos::class.java)
        var random_intent:String
        binding.botonRecoger.setOnClickListener(){
            when(random){
                0   ->  personaje.mochila.coger(cuchillo)
                1   ->  personaje.mochila.coger(espada)
                2   ->  personaje.mochila.coger(escudo)
                3   ->  personaje.mochila.coger(daga)
            }
            Toast.makeText(this, "cantidad de objetos:${personaje.mochila.cant_obj} y  peso total de la mochila:${personaje.mochila.peso_mochila} y el limite es ${personaje.mochila.limit}", Toast.LENGTH_SHORT).show()

            if (ActivityCiudad.calculo())
                startActivity(intent_aleatorizador)
            else{
                random_intent= ActivityCiudad.getRandomIntent()

                if (random_intent.equals("Mercader"))
                    startActivity(intent_mercader)
                else if (random_intent.equals("Objeto"))
                    startActivity(intent_objeto)
                else if (random_intent.equals("Enemigo"))
                    startActivity(intent_enemigo)
            }

        }
        binding.botonContinuar.setOnClickListener(){
            if (ActivityCiudad.calculo())
                startActivity(intent_aleatorizador)
            else{
                random_intent= ActivityCiudad.getRandomIntent()

                if (random_intent.equals("Mercader"))
                    startActivity(intent_mercader)
                else if (random_intent.equals("Objeto"))
                    startActivity(intent_objeto)
                else if (random_intent.equals("Enemigo"))
                    startActivity(intent_enemigo)
            }
        }

    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun imagenRandom(): Int {
        var random=Random.nextInt(4)
        when(random){
            0   ->  binding.imagen.setImageResource(R.drawable.cuchillo)
            1   ->  binding.imagen.setImageResource(R.drawable.espada)
            2   ->  binding.imagen.setImageResource(R.drawable.escudo)
            3   ->  binding.imagen.setImageResource(R.drawable.daga)

        }
        return random
    }
}