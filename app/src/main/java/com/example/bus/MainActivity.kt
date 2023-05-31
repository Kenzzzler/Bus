package com.example.bus

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var num : TextView
    var numPass = 0
    lateinit var plusPass : Button
    lateinit var minusPass : Button
    lateinit var pass : TextView
    lateinit var resetApp : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num = findViewById(R.id.num)
        plusPass = findViewById(R.id.plus)
        minusPass = findViewById(R.id.minus)
        pass = findViewById(R.id.passengers)
        resetApp = findViewById(R.id.reset)
        pass()

        plusPass.setOnClickListener {
            numPass++
            num.text = "$numPass"
            pass()
        }

        minusPass.setOnClickListener{
            numPass--
            num.text = "$numPass"
            pass()
        }

        resetApp.setOnClickListener {
            numPass = 0
            num.text = "$numPass"
            pass()
        }

    }
    private fun pass() {
        when(numPass){
            in 1..9 -> {
                pass.setTextColor(Color.BLUE)
                resetApp.visibility = View.INVISIBLE
                pass.text = "Осталось мест ${10 - numPass}"
                minusPass.isEnabled = true
                pass.textSize = 30F
            }
           10 -> {
                pass.setTextColor(Color.RED)
                resetApp.visibility = View.VISIBLE
                pass.text = "Пассажиров слишком много"
                pass.textSize = 20F
            }
           0 -> {
                pass.setTextColor(Color.GREEN)
                resetApp.visibility = View.INVISIBLE
                pass.text = "Все места свободны"
                minusPass.isEnabled = false
                pass.textSize = 30F
            }
        }
    }
}