package com.example.sleccionpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActivityPantallaEnBlanco : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_en_blanco)
        Toast.makeText(this, "PantallaEnBlanco", Toast.LENGTH_SHORT).show()
    }
}