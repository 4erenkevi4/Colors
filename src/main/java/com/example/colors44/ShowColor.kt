package com.example.colors44

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val COLOR = "Цвет"
private const val NAME = "Название"

class ShowColor : Fragment() {
    private var itColor: Int? = null
    private var itNameColor: String? = null
    //private lateinit var color: AppColor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itColor = it.getInt(COLOR)
            itNameColor = it.getString(NAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(
                R.layout.fragment_show_color, container,
        false)

        root.findViewById<TextView>(R.id.nameColor).setText(itNameColor)
        root.findViewById<View>(R.id.showColor).setBackgroundColor(itColor!!)

        return root
    }


    companion object {

            @JvmStatic
            fun newInstance (color: Int, name: String)=
                ShowColor().apply {
                    arguments = Bundle().apply {
                        putInt(COLOR,color!!)
                        putString(NAME, name)
                    }
                }


    }
    }