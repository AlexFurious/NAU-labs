package com.example.calculate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        textResult = findViewById(R.id.result_number)
        window.addFlags(1024)
        val getOperator = intent.getStringExtra("operator")
        var firstValue:Float? = intent.getFloatExtra("first_value", 0f)
        var secondValue:Float? = intent.getFloatExtra("second_value", 0f)
        if (firstValue == 0f || secondValue == 0f) {firstValue = null
        secondValue = null}
        check(
            operator = getOperator.toString(),
            firstValue = firstValue as Float?,
            secondValue = secondValue as Float?
        )
    }

    private fun check(operator: String, firstValue: Float?, secondValue: Float?) {
        var sum = 0f
        if (firstValue != null) textResult.text = sum.toString() else  {
            textResult.text = "Немає відповіді"
            return
        }
        if (secondValue != null) textResult.text = sum.toString() else {
            textResult.text = "Немає відповіді"
            return
        }
        when (operator) {
            "+" -> sum = firstValue + secondValue
            "-" -> sum = firstValue - secondValue
            "*" -> sum = firstValue * secondValue
            "/" -> sum = firstValue / secondValue
        }


        if (operator.equals("/") && secondValue == 0f) {textResult.text = "На нуль ділити не можна"
        return
        }
        if (operator.equals("*") && secondValue == 0f) {textResult.text = "0"
        return
        }
        textResult.text = sum.toString()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        intent.putExtra("first_value", 0f)
        intent.putExtra("second_value", 0f)
        finish()
    }
}