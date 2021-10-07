package com.example.recylerviewtest

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(context: Context, list: ArrayList<BookmarkData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var activity: Activity

    companion object {
        const val VIEW_TYPE_TEXT = 1
        const val VIEW_TYPE_IMAGE = 2
    }

    private val context: Context = context
    var list: ArrayList<BookmarkData> = list

    private inner class View1ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.chat_message)
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
            message.text = recyclerViewModel.text
        }
    }

    private inner class View2ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: ImageView = itemView.findViewById(R.id.chat_image_message)
        fun bind(position: Int) {
//            activity = context as Activity
            val recyclerViewModel = list[position]
            Glide.with(message.context).load(recyclerViewModel.image).into(message)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_TEXT) {
            return View1ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.bot_message_area, parent, false)
            )
        }
        return View2ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.bot_image_message_area, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].viewType === VIEW_TYPE_TEXT) {
            (holder as View1ViewHolder).bind(position)
        } else {
            (holder as View2ViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }
}