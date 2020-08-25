package com.sixhandsapps.recyclerviewssyncdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val numbers: IntArray): RecyclerView.Adapter<ItemVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH
            = ItemVH(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun getItemCount(): Int = numbers.size

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.setNumber(numbers[position])
    }
}