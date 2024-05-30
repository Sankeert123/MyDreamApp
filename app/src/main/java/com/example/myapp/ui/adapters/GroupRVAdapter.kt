package com.example.myApp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp.GroupsItemdData
import com.example.myApp.R

class GroupRVAdapter(private val itemList: List<GroupsItemdData>) : RecyclerView.Adapter<GroupRVAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

       val cartView = LayoutInflater.from(parent.context).inflate(R.layout.gruop_item_layout, parent,false)
        return viewHolder(cartView)
    }

    override fun getItemCount(): Int {

        return itemList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val itemList = itemList[position]
        Glide.with(holder.itemView.context).load(itemList.imgView).into(holder.imgView)
        holder.headerText.text = itemList.headerText
        holder.subText.text = itemList.subText

    }


    inner class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

         val imgView: ImageView = itemView.findViewById(R.id.frg_img_friends)
         val headerText: TextView = itemView.findViewById(R.id.frg_txt_friends)
         val subText: TextView = itemView.findViewById(R.id.frg_txt_no_expenses1)

    }
}