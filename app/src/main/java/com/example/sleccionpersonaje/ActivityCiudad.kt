package com.example.sleccionpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActivityCiudad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudad)
        Toast.makeText(this, "ciudad", Toast.LENGTH_SHORT).show()
    }
}