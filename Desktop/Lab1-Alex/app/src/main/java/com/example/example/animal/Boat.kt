package com.example.example.animal

import android.util.Log

class Boat : Vehicle(vehicleOld = 5) {
    override fun sound(name: String) {
        Log.d(name, "sound")
        super.sound(name)
    }

    override fun starting(name: String) {
        Log.d(name, "starting")
        super.starting(name)
    }
}