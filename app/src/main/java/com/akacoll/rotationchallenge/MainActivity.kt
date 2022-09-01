package com.akacoll.rotationchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = savedInstanceState?.getString("KEY_TEXT") ?: ""
        val tvMain = findViewById<TextView>(R.id.tv_main)
        val btnCounter = findViewById<Button>(R.id.btn_add)
        btnCounter.setOnClickListener {
            counter++
            tvMain.text = counter.toString()
        }
        tvMain.text = text

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        val textView = findViewById<TextView>(R.id.tv_main)
        val text = textView.text.toString()
        outState.putString("KEY_TEXT", text)
    }
}