package com.example.devpilotandroidnative

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //setupEdgeToEdgeMode()
        setupStatusBarPadding()
        setupSoloLevelingImage()
        setupAriseHybridLink()
    }

    /** Window & Insets Handling **/

    private fun setupEdgeToEdgeMode() =
        UiHelper.applyEdgeToEdge(
            activity = this,
            rootViewId = R.id.main
        )


    private fun setupStatusBarPadding() {
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.updatePadding(0, insets.top, insets.right, 0)
            WindowCompat.getInsetsController(window, window.decorView).apply {
                isAppearanceLightStatusBars = false
            }
            v.setBackgroundColor(getColor(R.color.deep_purple))
            WindowInsetsCompat.CONSUMED

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
