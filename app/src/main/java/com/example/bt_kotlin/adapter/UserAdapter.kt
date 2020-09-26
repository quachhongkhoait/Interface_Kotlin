package com.example.bt_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.bt_kotlin.R
import com.example.bt_kotlin.`interface`.OnItemClickListener
import com.example.bt_kotlin.adapter.UserAdapter.ItemViewHolder
import com.example.bt_kotlin.model.User


class UserAdapter(
    private val mList: List<User>,
    private val mListener: OnItemClickListener
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listuser, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvName.text = mList[position].name
        holder.tvAddress.text = mList[position].address
        holder.tvClick.setOnClickListener {
            mListener.onView(position)
        }
        holder.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            mListener.onCheck(position,b)
        }
    }

    class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        val cardView: CardView
        val checkBox: CheckBox
        val tvName: TextView
        val tvAddress: TextView
        val tvClick: TextView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvAddress = itemView.findViewById(R.id.tvAddress)
            tvClick = itemView.findViewById(R.id.button)
            imageView = itemView.findViewById(R.id.image)
            cardView = itemView.findViewById(R.id.cardview)
            checkBox = itemView.findViewById(R.id.checkbox)
        }
    }
}