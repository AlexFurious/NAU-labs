package com.example.example.vehicle

import android.util.Log

open class Vehicle(private val vehicleOld: Int) : InterfaceVehicle {
    private var soundVehicle: String = ""

    val arrayOfVehicle = arrayOf("Car", "Plane", "Boat")

    override fun sound(name: String) {
        soundVehicle = "жжжжжжжжжжж"
        if (vehicleOld > 0) {
            for (i in arrayOfVehicle.indices) {
                if (arrayOfVehicle[i] == name) {
                    Log.d("Vehicle", "$name say $soundVehicle")
                }
            }
        } else {
            soundVehicle = "жжжжжжж"
            Log.d("Vehicle", soundVehicle)
        }
    }

    override fun starting(name: String) {
        var counter = 0
        while (counter < arrayOfVehicle.size) {
            if (arrayOfVehicle[counter] == name) {
                Log.d(name, "Starting engine")
            }
            ++counter
        }
    }
}