package com.example.firtstry

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.firtstry.databinding.SecondPageBinding

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
        setContentView(R.layout.second_page)

        val buttontwo = findViewById<Button>(R.id.button2)
        buttontwo.setOnClickListener {
            val intent2 = Intent (this, MainActivity::class.java)
            startActivity(intent2)
*/



class MainActivity2 : AppCompatActivity()
{
    //binding
    private lateinit var binding : SecondPageBinding

    //other
    private var firstnumber = ""
    private var currentNumber = ""
    private var currentOperator = ""
    private var result = ""
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = SecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonBack = findViewById<Button>(R.id.button2)
        buttonBack.setOnClickListener {
            val intent1 = Intent (this, AplikasiActivity::class.java)
            startActivity(intent1)
        }
        //NoLimitScreen
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        //initViews
        binding.apply {
            // get all buttons
            binding.layoutMain.children.filterIsInstance<Button>().forEach { button ->
                //buttons click listener
                button.setOnClickListener {
                    //get clicked button text
                    val buttonText = button.text.toString()
                    when{
                        buttonText.matches(Regex("[0-9]"))->{
                            if(currentOperator.isEmpty())
                            {
                                firstnumber+=buttonText
                                tvResult.text = firstnumber
                            }else
                            {
                                currentNumber+=buttonText
                                tvResult.text = currentNumber
                            }
                        }
                        buttonText.matches(Regex("[+\\-*/]"))->{
                            currentNumber = ""
                            if (tvResult.text.toString().isNotEmpty())
                            {
                                currentOperator = buttonText
                                tvResult.text = "0"
                            }
                        }
                        buttonText == "="->{
                            if (currentNumber.isNotEmpty()&& currentOperator.isNotEmpty())
                            {
                                tvFormula.text = "$firstnumber$currentOperator$currentNumber"
                                result = evaluateExpression(firstnumber,currentNumber,currentOperator)
                                firstnumber = result
                                tvResult.text = result
                            }
                        }
                        buttonText == "."->{
                            if(currentOperator.isEmpty())
                            {
                                if (! firstnumber.contains("."))
                                {
                                    if(firstnumber.isEmpty())firstnumber+="0$buttonText"
                                    else firstnumber +=buttonText
                                    tvResult.text = firstnumber
                                }
                            }else
                            {
                                if (! currentNumber.contains("."))
                                {
                                    if(currentNumber.isEmpty()) currentNumber+="0$buttonText"
                                    else currentNumber +=buttonText
                                    tvResult.text = currentNumber
                                }
                            }
                        }
                        buttonText == "C"->{
                            currentNumber = ""
                            firstnumber = ""
                            currentOperator = ""
                            tvResult.text = "0"
                            tvFormula.text = ""
                        }
                    }
                }
            }


        }
    }

    //functions
    private fun evaluateExpression(firstNumber:String,secondNumber:String,operator:String):String
    {
        val num1  = firstNumber.toDouble()
        val num2  = secondNumber.toDouble()
        return when(operator)
        {
            "+"-> (num1+num2).toString()
            "-"-> (num1-num2).toString()
            "*"-> (num1*num2).toString()
            "/"-> (num1/num2).toString()
            else ->""
        }
    }
}