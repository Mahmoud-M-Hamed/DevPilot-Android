package com.example.devpilotandroidnative

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat;
import androidx.core.graphics.toColor
import androidx.core.view.WindowCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.core.view.updatePadding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        UiHelper.applyEdgeToEdge(
            activity = this,
            rootViewId = R.id.main
        )
        
        /*WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true*/

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) 
        { v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.updatePadding(0, insets.top, insets.right, 0)
            v.setBackgroundColor(getColor(R.color.deep_purple))
            WindowInsetsCompat.CONSUMED
        }

        val soloLevelingImageView = findViewById<ImageView>(R.id.solo_leveling_logo)
        val soloLevelingImageUrl: String = getString(R.string.solo_leveling_image_url)
        val errorDrawableImageViewId = R.drawable.vector_background

        UiHelper.retrieveImage(
            context = this,
            imageUrl = soloLevelingImageUrl,
            imageView = soloLevelingImageView,
            errorDrawable = errorDrawableImageViewId,
        )

        val ariseHybridLinkTV = findViewById<TextView>(R.id.arise_hybrid_link)
        UiHelper.underLineTextView(ariseHybridLinkTV)

        val soloLevelingWebsiteUrl: String = getString(R.string.solo_leveling_netmarble_url)
        val soloLevelingWebsiteURI: Uri = soloLevelingWebsiteUrl.toUri()
        ariseHybridLinkTV.setOnClickListener {
            val intentLauncher = Intent(Intent.ACTION_VIEW, soloLevelingWebsiteURI)
            startActivity(intentLauncher)
        }
    }


}