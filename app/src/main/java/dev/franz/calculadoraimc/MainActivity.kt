package dev.franz.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {

            val weight = edtWeight.text.toString().toDouble();
            val height = edtHeight.text.toString().toDouble();


            val resultado = weight / (height * height)
            val resultadoDecimal = (resultado * 100.0).roundToInt() / 100.0
            val nivel: String = grauObesidade(resultado)

            tvResultado.text = resultado.toString()


            tvResultado.text = "Seu IMC é $resultadoDecimal"
            tvNivelObesidade.text = "$nivel"

        }
    }

    private fun grauObesidade(resultado: Double): String {

        val nivel: String

        if (resultado in 0.0..18.5) {
            nivel = "Classificação: Abaixo do Peso"
        } else if (resultado in 18.5..24.9) {
            nivel = "Classificação: Peso Normal"
        } else if (resultado in 25.0..29.9) {
            nivel = "Classificação: Sobrepeso"
        } else if (resultado in 30.0..34.9) {
            nivel = "Classificação: Obesidade Grau 1"
        } else if (resultado in 35.0..39.9) {
            nivel = "Classificação: Obesidade Grau 2"
        } else {
            nivel = "Classificação: Obesidade Grau 3"
        }
        return nivel
    }
}


