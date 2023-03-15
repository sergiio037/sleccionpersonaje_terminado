package com.example.sleccionpersonaje

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import com.example.sleccionpersonaje.databinding.ActivityRazasBinding
import com.example.sleccionpersonaje.databinding.ActivityResumenBinding
import java.io.Serializable

import java.math.*
import java.util.*
import java.util.EnumSet.range



class Resumen : AppCompatActivity() {
    lateinit var binding: ActivityResumenBinding
    lateinit var fuerza: ProgressBar
    lateinit var defensa: ProgressBar
    lateinit var tamMochila: ProgressBar
    lateinit var vida: ProgressBar
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {

        var vida_t=0
        var fuerza_t=0
        var mochila_t=0
        var defensa_t=0

        super.onCreate(savedInstanceState)
        binding= ActivityResumenBinding.inflate(layoutInflater)
        setContentView(binding.root)




        if (personaje.clase.equals("guerrero"))
            binding.imageView1.setBackground(getDrawable(R.drawable.guerreropng))
        else if (personaje.clase.equals("ladron"))
            binding.imageView1.setBackground(getDrawable(R.drawable.ladron))
        else if (personaje.clase.equals("mago"))
            binding.imageView1.setBackground(getDrawable(R.drawable.mago))
        else if (personaje.clase.equals("berserker"))
            binding.imageView1.setBackground(getDrawable(R.drawable.berserker))

        if (personaje.raza.equals("humano"))
            binding.imageView2.setBackground(getDrawable(R.drawable.humano))
        else if (personaje.raza.equals("enano"))
            binding.imageView2.setBackground(getDrawable(R.drawable.enano))
        else if (personaje.raza.equals("goblin"))
            binding.imageView2.setBackground(getDrawable(R.drawable.goblin))
        else if (personaje.raza.equals("elfo"))
            binding.imageView2.setBackground(getDrawable(R.drawable.elfo))

        fuerza=findViewById(R.id.progressBarFuerza)
        defensa=findViewById(R.id.progressBarDefensa)
        tamMochila=findViewById(R.id.progressBarMochila)
        vida=findViewById(R.id.progressBarVida)

        fuerza_t= Random().nextInt(6)+10
        defensa_t=Random().nextInt(6)
        mochila_t=200
        vida_t=100
        personaje.fuerza=fuerza_t
        personaje.vida=vida_t
        personaje.defensa=defensa_t
        binding.textViewDefensaI.setText(defensa_t.toString())
        binding.textViewFuerzaI.setText(fuerza_t.toString())
        binding.textViewMochilaI.setText(mochila_t.toString())
        binding.textViewVidaI.setText(vida_t.toString())
        vida.setProgress(vida_t*10/100)
        fuerza.setProgress((fuerza_t-10)*10/5)
        tamMochila.setProgress(mochila_t*10/200)
        defensa.setProgress(defensa_t*10/5)
        Toast.makeText(this, fuerza_t.toString(), Toast.LENGTH_SHORT).show()
        var aleatorizador_eventos = Intent(this,Aleatorizador_de_eventos::class.java)
        binding.activityAleatorizador.setOnClickListener() {
            Handler().postDelayed({
                startActivity(aleatorizador_eventos)
            }, 1000)
        }

    }


}

