package com.mycalculatorapp
import android.os.Bundle
import androidx.activity.ComponentActivity

import com.mycalculatorapp.databinding.LayoutMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {

    lateinit var binding: LayoutMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= LayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAc.setOnClickListener{
            binding.inputtext.text=""
            binding.outputtext.text=""
        }


        binding.btn0.setOnClickListener {
            binding.inputtext.append("0")
        }

        binding.btnDot.setOnClickListener {
            binding.inputtext.append(".")
        }

        binding.btn1.setOnClickListener {
            binding.inputtext.append("1")
        }

        binding.btn2.setOnClickListener {
            binding.inputtext.append("2")
        }

        binding.btn3.setOnClickListener {
            binding.inputtext.append("3")
        }

        binding.btn4.setOnClickListener {
            binding.inputtext.append("4")
        }

        binding.btn5.setOnClickListener {
            binding.inputtext.append("5")
        }


        binding.btn6.setOnClickListener {
            binding.inputtext.append("6")
        }

        binding.btn7.setOnClickListener {
            binding.inputtext.append("7")
        }

        binding.btn8.setOnClickListener {
            binding.inputtext.append("8")
        }

        binding.btn9.setOnClickListener {
            binding.inputtext.append("9")
        }

        binding.btnDivision.setOnClickListener {
            binding.inputtext.append("/")
        }

        binding.btnLeftBtacket.setOnClickListener {
            binding.inputtext.append("(")
        }

        binding.btnRightBtacket.setOnClickListener {
            binding.inputtext.append(")")
        }

        binding.btnMultiply.setOnClickListener {
            binding.inputtext.append("*")
        }

        binding.btnSub.setOnClickListener {
            binding.inputtext.append("-")
        }

        binding.btnAdd.setOnClickListener {
            binding.inputtext.append("+")
        }

        binding.btnDel.setOnClickListener {
            val currentText = binding.inputtext.text.toString()
            if (currentText.isNotEmpty()) {
                val newText = currentText.substring(0, currentText.length - 1)
                binding.inputtext.text = newText
            }
        }


        binding.btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
                val result = expression.evaluate()
                val intResult = result.toInt()
                val longResult = result.toLong()

                if (result == longResult.toDouble()) {
                    binding.outputtext.text = longResult.toString()
                } else if (result == intResult.toDouble()) {
                    binding.outputtext.text = intResult.toString()
                } else {
                    binding.outputtext.text = result.toString()
                }
            } catch (e: Exception) {
                binding.outputtext.text = "Error!"
            }
        }




    }
}

