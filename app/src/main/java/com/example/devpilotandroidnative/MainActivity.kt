package com.example.devpilotandroidnative

import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

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
        val imageView = findViewById<ImageView>(R.id.soloLevelingLogo)
        val soloLevelingLogo: String = getString(R.string.solo_leveling_logo)
        Glide.with(this)
            .load(soloLevelingLogo)
            .error(R.drawable.vector_background)
            .into(imageView)
        
        val ariseHybridLinkTV = findViewById<TextView>(R.id.arise_hybrid_link)
        ariseHybridLinkTV.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }
}