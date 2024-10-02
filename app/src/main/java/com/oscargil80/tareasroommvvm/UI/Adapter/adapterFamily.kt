package com.oscargil80.tareasroommvvm.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.R


class adapterFamily(
    var FamilyList: List<Family>,
    val onClickListener: OnItemSelected
) : RecyclerView.Adapter<FamilyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FamilyViewHolder(layoutInflater.inflate(R.layout.item_family, parent, false))
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        val item = FamilyList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = FamilyList.size
}
