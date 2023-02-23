package com.example.sleccionpersonaje

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.sleccionpersonaje.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.guerreropng)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))


            personaje.clase="guerrero"
        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ladron)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            personaje.clase="ladron"
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.mago)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            personaje.clase="mago"
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.berserker)
            binding.imageView.setBackground(getDrawable(R.drawable.seleccion))

            binding.button.setBackground(getDrawable(R.drawable.seleccion))
            binding.button2.setBackground(getDrawable(R.drawable.seleccion))
            binding.button3.setBackground(getDrawable(R.drawable.seleccion))
            binding.button4.setBackground(getDrawable(R.drawable.seleccion))

            personaje.clase="berserker"
        }
        var intent_razas =Intent(this,Razas::class.java)
        binding.button5.setOnClickListener{

            if (personaje.clase.equals("guerrero"))
                binding.button.setBackground(getDrawable(R.drawable.seleccionado))
            if (personaje.clase.equals("ladron"))
                binding.button2.setBackground(getDrawable(R.drawable.seleccionado))
            if (personaje.clase.equals("mago"))
                binding.button3.setBackground(getDrawable(R.drawable.seleccionado))
            if (personaje.clase.equals("berserker"))
                binding.button4.setBackground(getDrawable(R.drawable.seleccionado))
            binding.imageView.setBackground(getDrawable(R.drawable.seleccionado))
            Handler().postDelayed({

                startActivity(intent_razas)
            }, 1000)

        }
    }

}