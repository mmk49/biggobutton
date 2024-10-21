package edu.uw.ischool.mmk49.biggobutton

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.camoButton)
        var clicks = 0
        val rotateAnimator = ObjectAnimator.ofFloat(btn, "rotation", 0f, 360f)
        rotateAnimator.setDuration(1000)
        rotateAnimator.repeatCount = ObjectAnimator.INFINITE
        rotateAnimator.repeatMode = ObjectAnimator.RESTART
        btn.setOnClickListener {
            clicks++
            var buttonText = ""
            buttonText = if(clicks == 1) {
                getString(R.string.first_push, clicks.toString())
            } else {
                getString(R.string.proceeding_pushes, clicks.toString())
            }
            btn.text = buttonText
            btn.setBackgroundColor(Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
            btn.setTextColor(Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
            if(clicks % 2 == 1) {
                rotateAnimator.start()
            } else {
                rotateAnimator.end()
            }
        }
    }
}