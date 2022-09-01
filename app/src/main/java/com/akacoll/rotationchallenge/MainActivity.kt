package com.akacoll.rotationchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_COUNTER = "KEY_COUNTER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMain = findViewById<TextView>(R.id.tv_main)
        val btnCounter = findViewById<Button>(R.id.btn_add)
        btnCounter.setOnClickListener {
            var counter = tvMain.text.toString().toInt()
            counter++
            tvMain.text = counter.toString()
        }
        val text = savedInstanceState?.getString(KEY_COUNTER) ?: "0"
        tvMain.text = text

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val textView = findViewById<TextView>(R.id.tv_main)
        val text = textView.text.toString()
        outState.putString(KEY_COUNTER, text)
    }
}