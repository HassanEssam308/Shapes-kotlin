package com.example.shapesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shapesapp.databinding.RowItemShapeBinding

class ShapeAdapter(private val arrayListOfShapes: ArrayList<ShapeItem>) :
    RecyclerView.Adapter<ShapeAdapter.ViewHolder>() {
    class ViewHolder(binding: RowItemShapeBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.RowIVImageOfShape
        val name = binding.RowTVNameOfShape

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowItemShapeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
       return arrayListOfShapes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.image.setImageResource(arrayListOfShapes[position].image)
        holder.name.text=""
        holder.image.setOnClickListener {
            holder.name.text=
                if (holder.name.text=="") arrayListOfShapes[position].name else ""
        }
    }
}