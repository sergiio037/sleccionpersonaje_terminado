package com.example.sleccionpersonaje

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sleccionpersonaje.databinding.ActivityMainBinding
import com.example.sleccionpersonaje.databinding.ActivityRazasBinding
import java.io.Serializable

@Suppress("DEPRECATION")
class Razas : AppCompatActivity() {
    lateinit var binding: ActivityRazasBinding



    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRazasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.humano)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))


            personaje.raza="humano"
        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.enano)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            personaje.raza="enano"
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.goblin)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            personaje.raza="goblin"
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            personaje.raza="elfo"
        }
        var resumen = Intent(this,Resumen::class.java)
        binding.button5.setOnClickListener{

            if (personaje.raza.equals("humano"))
                binding.button.setBackground(getDrawable(R.drawable.seleccionado))
            if (personaje.raza.equals("enano"))
                binding.button2.setBackground(getDrawable(R.drawable.seleccionado))
            if (personaje.raza.equals("goblin"))
                binding.button3.setBackground(getDrawable(R.drawable.seleccionado))
            if (personaje.raza.equals("elfo"))
                binding.button4.setBackground(getDrawable(R.drawable.seleccionado))
            binding.imageView.setBackground(getDrawable(R.drawable.seleccionado))

            Handler().postDelayed({
                startActivity(resumen)
            }, 1000)

        }
    }

}