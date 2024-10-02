package com.oscargil80.tareasroommvvm.UI.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.databinding.ItemFamilyBinding

class FamilyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemFamilyBinding.bind(view)

    fun render(
        family: Family,
        onClickListener: OnItemSelected
    ) {

        binding.parenFamily.text = family.parentesco
        binding.nombreFamily.text = family.nombre
        binding.apellidoFamily.text = family.apellido


        itemView.setOnClickListener {
            onClickListener.onItemView(family)
        }

        binding.delFamily.setOnClickListener {
            family.id?.let {
                onClickListener.onDeleteView(it)
            }
        }

    }
}

interface OnItemSelected{
    fun onItemView(family: Family)
    fun onDeleteView(id:Int)
}


