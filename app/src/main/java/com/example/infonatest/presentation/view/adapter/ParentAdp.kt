package com.example.infonatest.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.CheckBox
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infonatest.R
import com.example.infonatest.presentation.model.BenevitModel
import com.example.infonatest.presentation.model.ItemModel
import java.lang.Exception

class ParentAdp (private val sections: List<BenevitModel>): RecyclerView.Adapter<ParentAdp.ParentViewHolder>(),
    Filterable {
    private var sectionsFiltrable: List<BenevitModel> = sections
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_parent_list
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ParentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sectionsFiltrable.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val item = sectionsFiltrable[position]
        holder.tvTitle.text = item.title
        holder.childRecycler.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL,false)
        val adapter = ChildAdp(item.items)
        holder.childRecycler.adapter = adapter
    }
    inner class ParentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.title_list)
        val childRecycler: RecyclerView = itemView.findViewById(R.id.recycler_child)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(query: CharSequence?): FilterResults {
                val inputText = query.toString()
                sectionsFiltrable = if (inputText.isEmpty()) {
                    sections
                } else {
                    lateinit var temp: BenevitModel
                    var sectionsFilterableTemp: MutableList<BenevitModel> = ArrayList()
                    sectionsFilterableTemp.clear()
                    sectionsFiltrable.forEach {
                        var itemFilterableTemp: MutableList<ItemModel> = ArrayList()
                        itemFilterableTemp.clear()
                        it.items.forEach{itemModel ->
                            if (itemModel.name.contains(inputText)) {
                                itemFilterableTemp.add(itemModel)
                            }
                        }
                        if(itemFilterableTemp.isNotEmpty()){
                            temp = BenevitModel(
                                title = it.title,
                                items = itemFilterableTemp
                            )
                            sectionsFilterableTemp.add(temp)
                        }
                    }
                    sectionsFilterableTemp
                }
                val filterResult = FilterResults()
                filterResult.values = sectionsFiltrable
                return filterResult
            }
            override fun publishResults(query: CharSequence?, results: FilterResults?) {
                sectionsFiltrable = results?.values as List<BenevitModel>
                notifyDataSetChanged()
            }
        }
    }
}