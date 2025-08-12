package com.example.devpilotandroidnative

import android.R
import android.app.Activity
import android.app.StatusBarManager
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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