package br.com.conseng.kotlinsimplecalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getNumber1(): Float {
        return getNumberFromField(editNumber1)
    }

    private fun getNumber2(): Float {
        return getNumberFromField(editNumber2)
    }

    private fun getNumberFromField(view: EditText?): Float {
        var number: Float = 0F
        if ((null != view) && (!view.text.isNullOrBlank())) {
            number = view.text.toString().toFloat()
        }
        return number
    }

    private fun mostraResultado(valor1: Float, valor2: Float, operador: String, resultado: Float) {
        val texto = "$valor1 $operador $valor2 \n = \n $resultado"
        //val texto = valor1.toString() + " " + operador + " " + valor2.toString() + "\n=\n" + resultado.toString()
        resultText.setText(texto)
    }

    fun executaSoma(view: View) {
        val a = getNumber1()
        val b = getNumber2()
        val soma = a + b
        mostraResultado(a, b, "+", soma)
    }

    fun executaSubtracao(view: View) {
        val a = getNumber1()
        val b = getNumber2()
        val subtracao = a - b
        mostraResultado(a, b, "-", subtracao)
    }

    fun executaMultiplicacao(view: View) {
        val a = getNumber1()
        val b = getNumber2()
        val vezes = a * b
        mostraResultado(a, b, "*", vezes)
    }

    fun executaDivisao(view: View) {
        val a = getNumber1()
        val b = getNumber2()
        if (0F == b) {
            resultText.setText(getString(R.string.divisor_nulo))
        } else {
            val dividido = a / b
            mostraResultado(a, b, "/", dividido)
        }
    }
}
