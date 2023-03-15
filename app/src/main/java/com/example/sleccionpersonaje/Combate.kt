package com.example.sleccionpersonaje

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sleccionpersonaje.databinding.ActivityCombateBinding
import com.example.sleccionpersonaje.databinding.ActivityMercaderBinding
import kotlin.random.Random

class Combate : AppCompatActivity() {
    lateinit var binding: ActivityCombateBinding
    var pocion=Objeto(5,10,"pocion",20)
    var mapa_objetos:Map<String,Objeto> = mapOf(Pair("pocion",pocion))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent_objeto = Intent(this,Activity_objeto::class.java)
        val intent_enemigo = Intent(this,Combate::class.java)
        val intent_mercader = Intent(this,ActivityMercader::class.java)
        val intent_aleatorizador = Intent(this,Aleatorizador_de_eventos::class.java)
        var random_intent:String
        personaje.luchar()

        var enemigo=Enemigo(getRandomEnemigo())
        if (enemigo.clase.equals("Jefe"))
            binding.imagen.setBackground(getDrawable(com.example.sleccionpersonaje.R.drawable.berserker))
        else
            binding.imagen.setBackground(getDrawable(com.example.sleccionpersonaje.R.drawable.elfo))
        var random_atq=0
        var perdido =Intent(this,Dead::class.java)

        var curacion =true
        var curaciones= arrayListOf<String>()

        for (objeto in personaje.mochila.objetos){
            if (objeto.vida>0)
                curaciones.add(objeto.nombre)
            println(objeto.vida
                .toString()+"  vida")
        }
        var mochila_objetos_a = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, curaciones)
        var objeto_seleccionado=""
        mochila_objetos_a.clear()
        for (objeto in personaje.mochila.objetos){
            if (objeto.vida>0)
                mochila_objetos_a.add(objeto.nombre)}
        binding.spinnerObjeto.adapter=mochila_objetos_a
        binding.spinnerObjeto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            if (!mochila_objetos_a.isEmpty)
                objeto_seleccionado= mochila_objetos_a.getItem(position)!!
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Code to perform some action when nothing is selected
        }


        }
        binding.textObjeto.setOnClickListener(){
            if (personaje.mochila.eliminar(objeto_seleccionado)){
                personaje.vida= personaje.vida+20
                if(personaje.vida>100)
                    personaje.vida=100
                binding.progressBarVidaUsuario.setProgress(personaje.vida)


            }

            mochila_objetos_a.clear()
            for (objeto in personaje.mochila.objetos){
                if (objeto.vida>0)
                    mochila_objetos_a.add(objeto.nombre)
            }
            binding.spinnerObjeto.adapter=mochila_objetos_a



        }
        binding.textAtacar.setOnClickListener(){
            random_atq=Random.nextInt(1,7)
            if (random_atq>3){
                enemigo.vida=enemigo.vida- personaje.fuerza


            }
            personaje.vida= personaje.vida-(enemigo.ataque/(personaje.defensa+1))
            println(personaje.vida.toString()+"   "+enemigo.vida.toString())

            if(personaje.vida<=0){
                startActivity(perdido)
            }else if (enemigo.vida<=0){
                repeat(3){
                    personaje.mochila.coger(pocion)
                }
                personaje.mochila.dinero= personaje.mochila.dinero+100
                ActivityCiudad.enemigos=ActivityCiudad.enemigos+1
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
            binding.progressBarVidaUsuario.setProgress(personaje.vida)
            if (enemigo.clase.equals("Jefe"))
                binding.progressBarVidaEnemigo.setProgress(enemigo.vida/2)
            else
                binding.progressBarVidaEnemigo.setProgress(enemigo.vida)

        }
        binding.textHuir.setOnClickListener(){

            if (Random.nextInt(1,7)>4){
                ActivityCiudad.enemigos=ActivityCiudad.enemigos+1
                println("calculo  -> "+ActivityCiudad.calculo()+"   "+ActivityCiudad.enemigos)
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
            else{

                Toast.makeText(this, "No ha sido posible huir", Toast.LENGTH_SHORT).show()
                personaje.vida= personaje.vida-(enemigo.ataque/(personaje.defensa+1))
                binding.progressBarVidaUsuario.setProgress(personaje.vida)
                println(personaje.vida.toString()+"   "+enemigo.vida.toString())

                if(personaje.vida<=0){
                    startActivity(perdido)
                }}
        }

    }
    fun getRandomEnemigo(): String {
        val strings = arrayOf("Jefe","normal")
        val randomValue = Random.nextInt(strings.size)
        return strings.get(randomValue)
    }
}