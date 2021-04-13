package com.example.gottalearn_beta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExampleAdapter(private val exampleList: List<ExampleItem>
) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem=exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text=currentItem.text1
        holder.textView2.text=currentItem.text2



    }
    override fun getItemCount()=exampleList.size

    class ExampleViewHolder (itemView: View): RecyclerView.ViewHolder (itemView){
        val imageView: ImageView=itemView.findViewById(R.id.bookmark)
        val textView1: TextView=itemView.findViewById(R.id.text_view1)
        val textView2: TextView=itemView.findViewById(R.id.text_view2)


    }




}