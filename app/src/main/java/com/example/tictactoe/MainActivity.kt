package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = arrayOf(
            findViewById<Button>(R.id.btn00),
            findViewById<Button>(R.id.btn01),
            findViewById<Button>(R.id.btn02),
            findViewById<Button>(R.id.btn10),
            findViewById<Button>(R.id.btn11),
            findViewById<Button>(R.id.btn12),
            findViewById<Button>(R.id.btn20),
            findViewById<Button>(R.id.btn21),
            findViewById<Button>(R.id.btn22)
        )

        var currentPlayer = "X"

        for (btn in button) {
            btn.setOnClickListener {
                if(btn.text.isNotEmpty()) return@setOnClickListener
                btn.text = currentPlayer

                currentPlayer = if(currentPlayer =="X") "O" else "X"
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}