package com.example.colors44

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.ViewGroup
import android.widget.TextView

class ColorActivity() : AppCompatActivity() {

    private lateinit var color: AppColor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
       color = intent.getSerializableExtra(EXTRA_COLOR) as AppColor

        findViewById<ViewGroup>(R.id.color_container).setBackgroundColor(color.color)
        findViewById<TextView>(R.id.textView).text = (color.name)
    }

    companion object {

        private const val EXTRA_COLOR = "EXTRA_COLOR"

        @JvmStatic
        fun newInstance() = ColorActivity()}

        }



//fun getstartIntent(context: ColorsFragment, color: AppColor) = Intent(context, ColorActivity::class.java).apply {
//            putExtra(EXTRA_COLOR, color)