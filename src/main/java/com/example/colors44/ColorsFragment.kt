package com.example.colors44
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ColorsFragment : Fragment() {
    private val colorsList = mutableListOf<AppColor>()
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("UseRequireInsteadOfGet", "ResourceType")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_colors, container, false)
        var i = 0
        while (i < 500) {
            colorsList.add(AppColor(color = randomColor()))
            i++
        }
        recyclerView = rootView.findViewById(R.id.recycler)
        recyclerView.layoutManager = GridLayoutManager(this.activity, 3, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = ColorsAdapter(colorsList) {
            (requireActivity() as ReplaceInterface).replaceFragment(ShowColor.newInstance(it.color))
        }
        return rootView
    }

    fun randomColor(): Int {
        val rnd = Random()
        val colorRandom = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        return colorRandom
    }
}