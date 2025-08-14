package com.example.devpilotandroidnative

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AriseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_arise)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        UiHelper.setupStatusBarPadding(window = window, color = getColor(R.color.deep_purple))


        val toolbar = findViewById< Toolbar>(R.id.arise_toolbar)
        setSupportActionBar(toolbar)

        // Show back arrow in the toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val textFromMain = intent.getStringExtra("characterDescription")
        val ariseTV = findViewById<TextView>(R.id.arise_activity_TV_id)
        ariseTV.text = textFromMain
        
        val characterName = intent.getStringExtra("characterName")
        val characterNameDisplay = findViewById<TextView>(R.id.arise_activity_TV_id2)
        characterNameDisplay.text = characterName
        
    }

    // Handle back arrow click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed() // Go back to previous activity
            return true
        }
        //return super.onOptionsItemSelected(item)
        return false
    }
    
}