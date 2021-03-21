package com.example.colors44

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

private const val COLOR = "Цвет"
private const val NAME = "Название"
private var i = 0
private var b = 1

class QwizzFragment : Fragment() {
    private var itColor: Int? = null
    private var itNameColor: Int? = null
    private var folsColor: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itColor = it.getInt(COLOR)
            itNameColor = randomColor()
            folsColor = randomColor()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as ReplaceInterface).firstReplace()
        var root: View = inflater.inflate(R.layout.fragment_qwizz, container, false)
        root.findViewById<TextView>(R.id.color_one).text = itNameColor.toString()
        root.findViewById<TextView>(R.id.color_two).text = folsColor.toString()
        root.findViewById<View>(R.id.container_color).setBackgroundColor(randomColor())
        return root
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<TextView>(R.id.color_one)?.setOnClickListener {
            (requireActivity() as ReplaceInterface).nextReplace(i + b, true)
            i++
        }
        view?.findViewById<TextView>(R.id.color_two)?.setOnClickListener {
            (requireActivity() as ReplaceInterface).nextReplace(i + b, false)
            i++
        }
    }

    fun randomColor(): Int {
        val rnd = Random()
        val colorRandom = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        return colorRandom
    }

    companion object {
        fun newInstance(color: Int) =
                QwizzFragment().apply {
                    arguments = Bundle().apply {
                        putInt(COLOR, color)
                        putInt(NAME, color)
                    }
                }
    }
}
