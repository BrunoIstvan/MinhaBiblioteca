package br.com.bicmsystems.minhabiblioteca

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.bicmsystems.canivetesuico.demo.Calculadora
import br.com.bicmsystems.canivetesuico.toast.CustomToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSomar.setOnClickListener {

            if(validarCampos()) {

                val calc = Calculadora()
                tvResultado.text = calc.somar(edtFirstNumber.text.toString().toInt(),
                                                edtSecondNumber.text.toString().toInt()).toString()

            } else {

                Toast.makeText(this, "Informe o primeiro e segundo número", Toast.LENGTH_LONG).show()

            }
        }

        btnSubtrair.setOnClickListener {

            if(validarCampos()) {

                val calc = Calculadora()
                tvResultado.text = calc.subtrair(edtFirstNumber.text.toString().toInt(),
                        edtSecondNumber.text.toString().toInt()).toString()

            } else {

                Toast.makeText(this, "Informe o primeiro e segundo número", Toast.LENGTH_LONG).show()

            }
        }


        btnMultiplicar.setOnClickListener {

            if(validarCampos()) {

                val calc = Calculadora()
                tvResultado.text = calc.multiplicar(edtFirstNumber.text.toString().toInt(),
                        edtSecondNumber.text.toString().toInt()).toString()

            } else {

                Toast.makeText(this, "Informe o primeiro e segundo número", Toast.LENGTH_LONG).show()

            }
        }


        btnDividir.setOnClickListener {

            if(validarCampos(true)) {

                val calc = Calculadora()
                tvResultado.text = calc.dividir(edtFirstNumber.text.toString().toInt(),
                        edtSecondNumber.text.toString().toInt()).toString()

            } else {

                val customToast = CustomToast(this, layoutInflater)

                if(BuildConfig.REPORT_CRASH) {
                    //Toast.makeText(this, "Crash ligado", Toast.LENGTH_LONG).show()
                    customToast.showToast("Crash Ligado")
                } else {
                    //Toast.makeText(this, "Crash desligado", Toast.LENGTH_LONG).show()
                    customToast.showToast("Crash Desligado")
                }

                //Toast.makeText(this, "Informe o primeiro e segundo número (não pode ser igual a zero) ", Toast.LENGTH_LONG).show()

            }
        }



    }

    private fun validarCampos(isDivisao: Boolean = false) : Boolean {

        if(edtFirstNumber.text.isNullOrEmpty()) { return false }

        if(edtSecondNumber.text.isNullOrEmpty()) { return false }

        if(isDivisao && edtSecondNumber.text.toString().toInt() == 0 ) { return false }

        return true

    }



}
