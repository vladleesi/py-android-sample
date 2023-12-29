package dev.vladleesi.pysample.logger

import android.util.Log
import android.widget.Button

fun Any.logButton(button: Button?) {
    Log.d(this::class.java.simpleName, "'${button?.text}' button is pressed")
}
