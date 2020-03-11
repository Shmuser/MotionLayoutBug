package com.example.motionlayoutbugtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {

    private val motionLayout: MotionLayout by lazy {
        findViewById<MotionLayout>(R.id.motionLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        motionLayout.transitionToEnd()
    }
}
