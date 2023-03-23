package com.example.navegar_entre_activitys

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityMensaje : AppCompatActivity() {
  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_mensaje)

    val campoMensaje= findViewById<TextView>(R.id.textResultado)

    val miBundle: Bundle? = this.intent.extras

    if (miBundle != null){
      campoMensaje.text= "Bienvenido,${miBundle.getString("Promedio")},la materia es:${miBundle.getString("Materia")}, " +
        "sus notas son ${miBundle.getDouble("nota1")},${miBundle.getDouble("nota2")},${miBundle.getDouble("nota3")}" +
        "y su promedio es : ${miBundle.getDouble("prom")}"
    }
    val botonsalir:Button=findViewById(R.id.btnSalir)
    botonsalir.setOnClickListener { onClick() }
  }

  private fun onClick() {
    finish()
  }
}
