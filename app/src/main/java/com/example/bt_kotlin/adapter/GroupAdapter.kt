package com.example.bt_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bt_kotlin.R
import com.example.bt_kotlin.`interface`.OnItemClickListener
import com.example.bt_kotlin.model.Group
import de.hdodenhof.circleimageview.CircleImageView


class GroupAdapter(
    private val mList: List<Group>
) : RecyclerView.Adapter<GroupAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listgroup, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = ""+mList[position].name.toCharArray()[0]
    }

    class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: CircleImageView
        val textView: TextView

        init {
            imageView = itemView.findViewById(R.id.circleImageView)
            textView = itemView.findViewById(R.id.tvName)
        }
    }
}