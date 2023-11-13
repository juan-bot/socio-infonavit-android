package com.example.infonatest.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infonatest.R
import com.example.infonatest.presentation.model.ItemModel
import com.squareup.picasso.Picasso

class ChildAdp(private val benevits: List<ItemModel>): RecyclerView.Adapter<ChildAdp.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_product
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return benevits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(benevits[position])
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(obj: ItemModel) {
            val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
            val imgLogo: ImageView = itemView.findViewById(R.id.img_logo)
            val btn: Button = itemView.findViewById(R.id.btn_want)
            tvDesc.text = obj.label
            if(obj.locked){
                btn.visibility = View.VISIBLE
                tvDesc.visibility = View.INVISIBLE
            }
            else{
                btn.visibility = View.INVISIBLE
            }


            Picasso.get().load(obj.img).into(imgLogo)
        }
    }
}