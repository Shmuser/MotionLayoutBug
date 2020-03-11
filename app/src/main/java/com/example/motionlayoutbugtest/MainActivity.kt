package com.example.motionlayoutbugtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {

    private val motionLayout: MotionLayout by lazy {
        findViewById<MotionLayout>(R.id.motionLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn2)
        btn.setOnClickListener {
            when (motionLayout.currentState) {
                motionLayout.startState -> Toast.makeText(this, "was startState", Toast.LENGTH_SHORT).show()
                motionLayout.endState -> Toast.makeText(this, "was endState", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "was unknownState", Toast.LENGTH_SHORT).show()
            }
            if (motionLayout.currentState == motionLayout.endState) {
                motionLayout.transitionToStart()
            } else {
                motionLayout.transitionToEnd()
            }
            when (motionLayout.currentState) {
                motionLayout.startState -> Toast.makeText(this, "now is startState", Toast.LENGTH_SHORT).show()
                motionLayout.endState -> Toast.makeText(this, "now is endState", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "now is unknownState", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        motionLayout.transitionToEnd()
    }
}
