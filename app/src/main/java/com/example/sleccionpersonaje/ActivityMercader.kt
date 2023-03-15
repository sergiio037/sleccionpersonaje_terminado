package com.example.sleccionpersonaje

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.sleccionpersonaje.ActivityCiudad.Companion.calculo
import com.example.sleccionpersonaje.ActivityCiudad.Companion.getRandomIntent
import com.example.sleccionpersonaje.databinding.ActivityCiudadBinding
import com.example.sleccionpersonaje.databinding.ActivityMercaderBinding
import com.example.sleccionpersonaje.databinding.ActivityObjetoBinding

class ActivityMercader : AppCompatActivity() {
    lateinit var binding: ActivityMercaderBinding
    val cuchillo = Objeto(5,10,"cuchillo",0)
    val espada = Objeto(5,10,"espada",0)
    val escudo = Objeto(5,10,"escudo",0)
    val daga = Objeto(5,10,"daga",0)
    val cunai = Objeto(5,10,"cunai",0)
    val shuriken = Objeto(5,10,"shuriken",0)
    val lanza = Objeto(5,10,"lanza",0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textComerciar.setOnClickListener(){
            binding.botonesMercader.isVisible=true
            binding.spinners.isVisible=true
        }

        binding.botonCancelar.setOnClickListener(){
            binding.botonesMercader.isVisible=false
            binding.spinners.isVisible=false
        }

        val intent_objeto = Intent(this,Activity_objeto::class.java)
        val intent_enemigo = Intent(this,Combate::class.java)
        val intent_mercader = Intent(this,ActivityMercader::class.java)
        val intent_aleatorizador = Intent(this,Aleatorizador_de_eventos::class.java)

        var todos_objetos=arrayListOf("cuchillo","espada","escudo","daga","cunai")
        var mapa_objetos:Map<String,Objeto> = mapOf(Pair("cuchillo",cuchillo),Pair("espada",espada),Pair("escudo",escudo),Pair("daga",daga),Pair("cunai",cunai))
        val cantidad_objetos = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, arrayOf("1","2","3","4","5"))
        val todos_objetos_a = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, todos_objetos)
        var mochila_objetos_a = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, personaje.mochila.arrayObjetos())
        var comprar=false
        var vender=false
        var objeto_seleccionado=""
        var cantidad=0
        var random_intent: String
        binding.textContinuar.setOnClickListener(){
            if (calculo())
                startActivity(intent_aleatorizador)
            else{
                random_intent=getRandomIntent()

                if (random_intent.equals("Mercader"))
                    startActivity(intent_mercader)
                else if (random_intent.equals("Objeto"))
                    startActivity(intent_objeto)
                else if (random_intent.equals("Enemigo"))
                    startActivity(intent_enemigo)
            }
            }
        binding.spinnerCantidad.adapter= cantidad_objetos
        binding.spinnerObjeto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (comprar)
                    objeto_seleccionado=todos_objetos_a.getItem(position).toString()
                else if (personaje.mochila.objetos.isNotEmpty() && vender)
                    objeto_seleccionado= personaje.mochila.objetos.get(position).nombre
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }


        }

        binding.spinnerCantidad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                cantidad=position+1

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }


        }
        binding.botonComprar.setOnClickListener(){

            if (comprar){
                for (x in 1..cantidad)
                    personaje.mochila.coger(mapa_objetos[objeto_seleccionado]!!)
                Toast.makeText(this, "cantidad de objetos:${personaje.mochila.cant_obj} y  peso total de la mochila:${personaje.mochila.peso_mochila} y el limite es ${personaje.mochila.limit}", Toast.LENGTH_SHORT).show()
            }else{
                binding.spinnerObjeto.adapter=todos_objetos_a
                comprar=true
                vender=false}
        }
        mochila_objetos_a.clear()
        for (objeto in personaje.mochila.objetos){
            mochila_objetos_a.add(objeto.nombre)
        }

        binding.spinnerObjeto.adapter=mochila_objetos_a
        binding.botonVender.setOnClickListener(){

            if (vender){
                for (x in 1..cantidad)
                    if(personaje.mochila.eliminar(objeto_seleccionado))
                        personaje.mochila.dinero=+125
                Toast.makeText(this, "cantidad de objetos:${personaje.mochila.cant_obj} y  peso total de la mochila:${personaje.mochila.peso_mochila} y el limite es ${personaje.mochila.limit}", Toast.LENGTH_SHORT).show()
            }else{
                comprar=false
                vender=true}
            mochila_objetos_a.clear()
            for (objeto in personaje.mochila.objetos){
                mochila_objetos_a.add(objeto.nombre)
            }

            binding.spinnerObjeto.adapter=mochila_objetos_a

        }

}
}
