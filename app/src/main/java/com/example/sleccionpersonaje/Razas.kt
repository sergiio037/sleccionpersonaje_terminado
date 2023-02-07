package com.example.sleccionpersonaje

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sleccionpersonaje.databinding.ActivityMainBinding
import com.example.sleccionpersonaje.databinding.ActivityRazasBinding

class Razas : AppCompatActivity() {
    lateinit var binding: ActivityRazasBinding

    lateinit var sel_raza :  String

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        var sel_clase= intent.getStringExtra("CLASE")
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


            sel_raza="humano"
        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.enano)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            sel_raza="enano"
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.goblin)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            sel_raza="goblin"
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            sel_raza="elfo"
        }
        var resumen = Intent(this,Resumen::class.java)
        binding.button5.setOnClickListener{

            if (sel_raza.equals("humano"))
                binding.button.setBackground(getDrawable(R.drawable.seleccionado))
            if (sel_raza.equals("enano"))
                binding.button2.setBackground(getDrawable(R.drawable.seleccionado))
            if (sel_raza.equals("goblin"))
                binding.button3.setBackground(getDrawable(R.drawable.seleccionado))
            if (sel_raza.equals("elfo"))
                binding.button4.setBackground(getDrawable(R.drawable.seleccionado))
            binding.imageView.setBackground(getDrawable(R.drawable.seleccionado))
            resumen.putExtra("CLASE", sel_clase)
            resumen.putExtra("RAZA", sel_raza)
            Handler().postDelayed({
                startActivity(resumen)
            }, 1000)

        }
    }
}