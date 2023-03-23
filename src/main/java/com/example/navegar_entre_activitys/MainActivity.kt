package com.example.navegar_entre_activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

  private var campoTexto: EditText? = null
  private var materia: EditText? = null
  private var nota1: EditText? = null
  private var nota2: EditText? = null
  private var nota3: EditText? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    campoTexto=findViewById(R.id.idNombreTxt)
    materia=findViewById(R.id.idMateriaTxt)
    nota1=findViewById(R.id.idNota1Txt)
    nota2=findViewById(R.id.idNota2Txt)
    nota3=findViewById(R.id.idNota3Txt)

    val MiBoton:Button= findViewById(R.id.btnIngresar)
    MiBoton.setOnClickListener{Onclick(1)}

    val BotonPantalla:Button=findViewById(R.id.btnpantalla)
    BotonPantalla.setOnClickListener{Onclick(2)}
  }

  @SuppressLint("SetTextI18n")
  private fun Onclick(boton: Int){
    when(boton){
      1 ->{
        val txtResultado:TextView=findViewById(R.id.txtRespuesta)
        val nombre:String=campoTexto!!.text.toString()
        val campomateria: String= materia!!.text.toString()

        val camponota1:Double = nota1!!.text.toString().toDouble()
        val camponota2:Double = nota2!!.text.toString().toDouble()
        val camponota3:Double = nota3!!.text.toString().toDouble()

        val prom:Double =(camponota1 + camponota2 + camponota3)/3

        if (prom>=3.5){
          txtResultado.text = "$nombre GANO LA MATERIA: $campomateria CON: $prom"
          txtResultado.setTextColor(Color.GREEN)
        } else{
          txtResultado.text= "$nombre PERDIO LA MATERIA $campomateria CON: $prom"
          txtResultado.setTextColor(Color.RED)
        }
        Toast.makeText(this, "Bienvenido $nombre, el nombre de la materia es: $campomateria su promedio es $prom" ,Toast.LENGTH_LONG).show()

      }
      2 -> {
        val txtResultado:TextView=findViewById(R.id.txtRespuesta)
        val nombre:String=campoTexto!!.text.toString()
        val campomateria: String= materia!!.text.toString()
        val camponota1:Double = nota1!!.text.toString().toDouble()
        val camponota2:Double = nota2!!.text.toString().toDouble()
        val camponota3:Double = nota3!!.text.toString().toDouble()
        val prom:Double =(camponota1 + camponota2 + camponota3)/3

        if (prom>=3.5){
          txtResultado.text = "$nombre GANO LA MATERIA: $campomateria CON: $prom"
          txtResultado.setTextColor(Color.GREEN)
        } else{
          txtResultado.text= "$nombre PERDIO LA MATERIA $campomateria CON: $prom"
          txtResultado.setTextColor(Color.RED)
        }
        val intent = Intent(this,ActivityMensaje::class.java)
        val miBundle = Bundle()
        miBundle.putString("Promedio",campoTexto!!.text.toString())
        miBundle.putString("Materia",materia!!.text.toString())
        miBundle.putDouble("nota1",nota1!!.text.toString().toDouble())
        miBundle.putDouble("nota2",nota2!!.text.toString().toDouble())
        miBundle.putDouble("nota3", nota3!!.text.toString().toDouble())
        miBundle.putDouble("prom", prom)
        intent.putExtras(miBundle)
        startActivity(intent)
      }
    }

  }
}
