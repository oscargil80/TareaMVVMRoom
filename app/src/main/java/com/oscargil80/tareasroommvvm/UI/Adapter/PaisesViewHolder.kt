package com.oscargil80.tareasroommvvm.UI.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.databinding.ItemPaisesBinding

class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemPaisesBinding.bind(view)

    fun render(
        paises: Paises,
        onClickListener: OnClickEvent
    ) {
        binding.nombrePais.text = paises.nombre
        binding.capitalPais.text = paises.capital
        binding.contiPais.text = paises.continente

        itemView.setOnClickListener {
            onClickListener.onClickItem(paises)
        }

        binding.delPais.setOnClickListener {
//            onClickListener.onClickDelete(paises.id!!)
            paises.id?.let { it1 ->
                onClickListener.onClickDelete(it1)
            }
        }
    }
}

interface OnClickEvent {
    fun onClickItem(pais: Paises)
    fun onClickDelete(id: Int)
}
