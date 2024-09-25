package com.oscargil80.tareasroommvvm.ui.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Personal
import com.oscargil80.tareasroommvvm.databinding.ItemPersonalBinding

class PersonalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemPersonalBinding.bind(view)

    fun render(
        personal: Personal,
        onClickListener: OnPersonalClickListener
    ) {
        binding.cedPersonal.text = personal.cedula
        binding.nombrePersonal.text = personal.nombre
        binding.direccionPersonal.text = personal.dir

        itemView.setOnClickListener {
         onClickListener.onItemClick(personal)
        }

        binding.delPersonal.setOnClickListener {
            personal.id?.let {
                    id -> onClickListener.onImageClick(id)
            }
        }
    }
}

interface OnPersonalClickListener {
    fun onImageClick(id: Int)
    fun onItemClick(personal: Personal)
}
