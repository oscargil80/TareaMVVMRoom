package com.oscargil80.tareasroommvvm.ui.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.databinding.ItemPaisesBinding

class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

private  var binding = ItemPaisesBinding.bind(view)

    fun render(
        Paises: Paises
        /*,         onClickListener: (Paises) -> Unit,
        onItemSeleted: (Int) -> Unit*/
    ) {

        binding.codigoPais.text = Paises.codigoPais
        binding.nombrePais.text = Paises.nombrePais
        binding.continentePais.text = Paises.continentePais

    }
}