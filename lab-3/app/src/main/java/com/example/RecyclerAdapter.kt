package com.example

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.R
import com.example.app.items.Item

class RecyclerAdapter(private val itemList: List<Item>, private val navController: NavController) :
    RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {
    companion object {
        private var size = 12345
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle: TextView = itemView.findViewById(R.id.title)
        val textAuthor: TextView = itemView.findViewById(R.id.author)
        val textDate: TextView = itemView.findViewById(R.id.pubDate)
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //title
        //author
        //pubDate
        //image
        holder.textAuthor.text = itemList[position].author
        holder.textTitle.text = itemList[position].title
        holder.textDate.text = itemList[position].pubDate
        Glide.with(holder.itemView).load(itemList[position].enclosure.link).into(holder.imageView)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data", itemList[position].pubDate)
            bundle.putString("description", itemList[position].description)
            bundle.putString("author", itemList[position].author)
            navController.navigate(R.id.action_fragmentMain_to_fragmentOther, bundle)
        }

    }

    override fun getItemCount(): Int {
        size = itemList.size
        Log.d("Size", size.toString())
        return size
    }

}