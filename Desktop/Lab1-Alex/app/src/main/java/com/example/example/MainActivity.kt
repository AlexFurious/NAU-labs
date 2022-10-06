package com.example.example

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.example.animal.Boat
import com.example.example.animal.Car
import com.example.example.animal.Plane

class MainActivity : AppCompatActivity() {


    private lateinit var planeArray: Array<Button>
    private lateinit var boatArray: Array<Button>
    private lateinit var car: Array<Button>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boatArray = arrayOf(findViewById<Button>(R.id.btn_0), findViewById<Button>(R.id.btn_1))
        car = arrayOf(findViewById(R.id.btn_2), findViewById(R.id.btn_3))
        planeArray = arrayOf(findViewById<Button>(R.id.btn_4), findViewById<Button>(R.id.btn_5))

        click()
    }


    private fun click() {
        boatArray.first().setOnClickListener {
            val boat = Boat()
            boat.sound("Boat")
        }
        boatArray.last().setOnClickListener {
            val boat = Boat()
            boat.starting("Boat")
        }
        planeArray.first().setOnClickListener {
            val plane = Plane()
            plane.sound("Plane")
        }
        planeArray.last().setOnClickListener {
            val plane = Plane()
            plane.starting("Plane")
        }
        car.first().setOnClickListener {
            val car = Car()
            car.sound("Car")
        }
        car.last().setOnClickListener {
            val car = Car()
            car.starting("Car")
        }
    }
}