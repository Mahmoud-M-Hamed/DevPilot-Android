package com.example.devpilotandroidnative

import android.app.Activity
import android.app.StatusBarManager
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.bumptech.glide.Glide


object UiHelper {
    
    fun applyEdgeToEdge(activity: Activity, rootViewId: Int) {
        ViewCompat.setOnApplyWindowInsetsListener(activity.findViewById(rootViewId))
        { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

     fun setupStatusBarPadding(window: Window, color: Int) {
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.updatePadding(insets.left, insets.top, insets.right, insets.bottom)
            WindowCompat.getInsetsController(window, window.decorView).apply {
                isAppearanceLightStatusBars = false
            }

            val systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)


            v.setBackgroundColor(color)
            WindowInsetsCompat.CONSUMED

        }

    }
    

    fun retrieveImage(
        context: Context,
        imageView: ImageView,
        imageUrl: String,
        errorDrawable: Int
    ) =
        Glide.with(context)
            .load(imageUrl)
            .error(errorDrawable)
            .into(imageView)


    fun underLineTextView(textView: TextView) {
        textView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

}