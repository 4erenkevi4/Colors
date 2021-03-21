package com.example.colors44

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val COLOR = "Цвет"
private const val NAME = "Название"

class ShowColor : Fragment() {
    private var itColor: Int? = null
    private var itNameColor: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itColor = it.getInt(COLOR)
            itNameColor = it.getInt(NAME)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(
                R.layout.fragment_show_color, container,
                false)
        root.findViewById<TextView>(R.id.nameColor).text = "This color HEX code " + itNameColor.toString()
        root.findViewById<View>(R.id.showColor).setBackgroundColor(itColor!!)
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
                ShowColor().apply {
                    arguments = Bundle().apply {
                        putInt(COLOR, color)
                        putInt(NAME, color)
                    }
                }
    }
}