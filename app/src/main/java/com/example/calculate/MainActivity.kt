package com.example.calculate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var firstValueEditText: EditText
    private lateinit var secondValueEditText: EditText
    private lateinit var plusBtn: AppCompatButton
    private lateinit var minusBtn: AppCompatButton
    private lateinit var divBtn: AppCompatButton
    private lateinit var multiplyBtn: AppCompatButton
    private lateinit var perehod: AppCompatButton
    private var Myintent: Intent?=null
    private lateinit var delete: AppCompatButton
    var getFirstValue:Float? = null
    var getSecondValue:Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        window.addFlags(1024)
        val array = arrayOf(plusBtn, minusBtn, divBtn, multiplyBtn)
         Myintent = Intent(this, ResultActivity::class.java)
        for (i in array.indices) {
            array[i].setOnClickListener {

                if (firstValueEditText.text.toString().isNotEmpty() && secondValueEditText.toString().isNotEmpty()
                ) {
                    getFirstValue = firstValueEditText.text.toString().toFloat()
                    getSecondValue = secondValueEditText.text.toString().toFloat()
                }
                when (i) {
                    0 -> {
                        Myintent?.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "+")
                        }
                        Log.d("TAG", "plus")
                    }
                    1 -> {
                        Myintent?.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "-")
                        }
                        Log.d("TAG", "minus")
                    }
                    2 -> {
                        Myintent?.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "/")
                        }
                        Log.d("TAG", "division")
                    }
                    3 -> {
                        Myintent?.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "*")
                        }
                        Log.d("TAG", "multiplication")
                    }
                }

            }
        }
    }

    private fun init() {
        firstValueEditText = findViewById(R.id.et_first_value)
        secondValueEditText = findViewById(R.id.et_second_value)
        plusBtn = findViewById(R.id.plus_btn)
        minusBtn = findViewById(R.id.minus_btn)
        divBtn = findViewById(R.id.div_btn)
        multiplyBtn = findViewById(R.id.multiply_btn)
        perehod = findViewById(R.id.perehod_btn)
        perehod.setOnClickListener {
            intent.putExtra("first_value", getFirstValue)
            intent.putExtra("second_value", getSecondValue)
            startActivity(Myintent) }
        delete = findViewById(R.id.delete_btn)
        delete.setOnClickListener { firstValueEditText.setText("")
        secondValueEditText.setText("")}
    }

    override fun onResume() {
        super.onResume()
        getFirstValue = null
        getSecondValue = null
    }
}