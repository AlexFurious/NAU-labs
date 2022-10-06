package com.example.example.vehicle

import android.util.Log

class Plane: Vehicle(vehicleOld = 3) {
    override fun sound(name: String) {
        Log.d(name, "sound")
        super.sound(name)
    }

    override fun starting(name: String) {
        Log.d(name, "starting")
        super.starting(name)
    }
}