package com.sixhandsapps.recyclerviewssyncdemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemVH(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setNumber(number: Int) {
        (itemView as TextView).text = number.toString()
    }
}