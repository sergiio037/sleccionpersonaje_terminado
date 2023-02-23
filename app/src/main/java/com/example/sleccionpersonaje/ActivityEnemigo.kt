package com.example.sleccionpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActivityEnemigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enemigo)
        Toast.makeText(this, "Enemigo", Toast.LENGTH_SHORT).show()
    }
}