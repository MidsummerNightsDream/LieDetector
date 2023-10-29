package com.example.liedetector.utils.extensions

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.nextActivity(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

fun Context.toast(string: String){
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

