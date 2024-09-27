package com.oscargil80.tareasroommvvm.ui.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.databinding.ItemPaisesBinding

class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

private  var binding = ItemPaisesBinding.bind(view)

    fun render(
        paises: Paises,
        onClikListener: onPersonalClickListener
    ) {
        binding.codigoPais.text = paises.codigoPais
        binding.nombrePais.text = paises.nombrePais
        binding.continentePais.text = paises.continentePais

        itemView.setOnClickListener {
            onClikListener.onClickItem(paises)
        }

        binding.viewDelete.setOnClickListener {
            paises.id.let {
                if (it != null) {
                    onClikListener.onDeleteListener(it)
                }
            }
        }


    }
}

interface onPersonalClickListener{
    fun onDeleteListener(id:Int)
    fun onClickItem(pais: Paises)
}