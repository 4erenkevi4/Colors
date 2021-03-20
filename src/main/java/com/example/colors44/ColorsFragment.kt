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



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ColorsFragment : Fragment() {


    private val colorsList = mutableListOf<AppColor>()
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("UseRequireInsteadOfGet", "ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_colors, container, false)
        colorsList.add(AppColor(Color.GRAY, name = "GRAY"))
        colorsList.add(AppColor(Color.RED, name = "RED"))
        colorsList.add(AppColor(Color.BLUE, name = "BLUE"))
        colorsList.add(AppColor(Color.GRAY, name = "GRAY"))
        colorsList.add(AppColor(Color.YELLOW, name = "YELLOW"))
        colorsList.add(AppColor(Color.CYAN, name = "CYAN"))
        colorsList.add(AppColor(Color.DKGRAY, name = "DKGRAY"))
        colorsList.add(AppColor(Color.GREEN, name = "GREEN"))
        colorsList.add(AppColor(Color.BLUE, name = "BLUE"))
        colorsList.add(AppColor(Color.RED, name = "RED"))
        colorsList.add(AppColor(Color.DKGRAY, name = "DKGRAY"))
        colorsList.add(AppColor(Color.BLUE, name = "BLUE"))
        colorsList.add(AppColor(Color.YELLOW, name = "YELLOW"))
        recyclerView = rootView.findViewById(R.id.recycler)
        recyclerView.layoutManager = GridLayoutManager(this.activity, 3, GridLayoutManager.VERTICAL, false)
        //val adapter = ColorsAdapter(colorsList, )
        recyclerView.adapter = ColorsAdapter(colorsList){

                (   requireActivity() as MainInterface).replaceFragment(ShowColor.newInstance(it.color,it.name))
        }

            return rootView
    }


    companion object {

        fun newInstance(param1: String, param2: String) =
            ColorsFragment().apply {
                this.arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}