package com.example.nammakathey.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nammakathey.R
import com.example.nammakathey.model.Hero

class DistrictAdapter(
    private val list: List<Hero>,
    private val onClick: (Hero) -> Unit
) : RecyclerView.Adapter<DistrictAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val districtName: TextView = view.findViewById(R.id.tvDistrictName)
        val heroName: TextView = view.findViewById(R.id.tvHeroName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_district, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.districtName.text = item.district
        holder.heroName.text = item.hero

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = list.size
}