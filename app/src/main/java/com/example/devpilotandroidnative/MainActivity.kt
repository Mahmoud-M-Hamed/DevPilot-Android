package com.example.devpilotandroidnative

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        
        UiHelper.setupStatusBarPadding(window = window, color = getColor(R.color.deep_purple))
        setupSoloLevelingImage()
        setupAriseHybridLink()
        
        val ariseButton = findViewById<Button>(R.id.arise_button)
        val changeDescriptionButton = findViewById<Button>(R.id.change_character_description_btn)
        val jinwooTextView = findViewById<TextView>(R.id.jinwoo_character_description)
        
        
        ariseButton.setOnClickListener { view -> 
            val ariseActivityIntent = Intent(this@MainActivity, AriseActivity::class.java)
            ariseActivityIntent.putExtra("characterName", "Sung Jinwoo")
            ariseActivityIntent.putExtra("characterDescription", jinwooTextView.text)
            startActivity(ariseActivityIntent)
        }

        var isDefaultDescription = true

        changeDescriptionButton.setOnClickListener {

            if (isDefaultDescription) {
                "This is Jinwoo Arise era...".also { jinwooTextView.text = it }
            } else {
                jinwooTextView.text = getString(R.string.jinwoo_character_description)
            }
            isDefaultDescription = !isDefaultDescription
            
            val ariseActivityIntent = Intent(this@MainActivity, AriseActivity::class.java)
            ariseActivityIntent.putExtra("characterDescription", jinwooTextView.text)
            
        }
        
        
        
    }
    
    

    /** ------------------------
     *  Image Setup
     *  ------------------------ */
    private fun setupSoloLevelingImage() {
        val soloLevelingImageView = findViewById<ImageView>(R.id.solo_leveling_logo)
        val soloLevelingImageUrl = getString(R.string.solo_leveling_image_url)
        val errorDrawableImageViewId = R.drawable.vector_background

        UiHelper.retrieveImage(
            context = this,
            imageUrl = soloLevelingImageUrl,
            imageView = soloLevelingImageView,
            errorDrawable = errorDrawableImageViewId,
        )
    }

    /** ------------------------
     *  Link Handling
     *  ------------------------ */
    private fun setupAriseHybridLink() {
        val ariseHybridLinkTV = findViewById<TextView>(R.id.arise_hybrid_link)
        UiHelper.underLineTextView(ariseHybridLinkTV)

        val soloLevelingWebsiteURI: Uri = getString(R.string.solo_leveling_netmarble_url).toUri()
        ariseHybridLinkTV.setOnClickListener {
            openWebsite(soloLevelingWebsiteURI)
        }
    }

    private fun openWebsite(uri: Uri) {
        val intentLauncher = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intentLauncher)
    }
}
