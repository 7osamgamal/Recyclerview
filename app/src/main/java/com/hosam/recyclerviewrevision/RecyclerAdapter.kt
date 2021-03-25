package com.hosam.recyclerviewrevision

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.exampleitem.view.*

class RecyclerAdapter(val list:List<ItemsModul>) : RecyclerView.Adapter<RecyclerAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.exampleitem,parent,false)
        return ExampleViewHolder(view)

    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
      val CurrentItem=list[position]
        holder.imageview.setImageResource(CurrentItem.image)
        holder.text1.text=CurrentItem.text1
        holder.text2.text=CurrentItem.text2
    }

    class ExampleViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val imageview: ImageView = itemview.emotion
        val text1: TextView = itemview.text1
        val text2: TextView = itemview.text2
    }
}