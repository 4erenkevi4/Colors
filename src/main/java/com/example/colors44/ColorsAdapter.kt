package com.example.colors44

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorsAdapter(
    private val colors: MutableList<AppColor>,
private val onClick: (AppColor) -> Unit
):RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_color, parent, false)

            return ColorsViewHolder(view, onClick)

        }

        override fun onBindViewHolder(holder: ColorsAdapter.ColorsViewHolder, position: Int) {

            holder.bind(colors[position])
        }

        override fun getItemCount(): Int = colors.size

        class ColorsViewHolder(
            view: View,
            private val onClick: (AppColor) -> Unit
        ) : RecyclerView.ViewHolder(view){
            val root : View = view.findViewById(R.id.color)
            private val namesColor: TextView = view.findViewById(R.id.textView)


            fun bind (color: AppColor){
                root.setBackgroundColor(color.color)
                namesColor.text = color.name
                root.setOnClickListener {
                    onClick(color)
                }

            }


        }
    }


