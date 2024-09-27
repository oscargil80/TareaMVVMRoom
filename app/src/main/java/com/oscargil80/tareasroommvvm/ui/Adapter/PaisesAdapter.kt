package com.oscargil80.tareasroommvvm.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.R


class PaisesAdapter(
    var PaisesList: List<Paises>,
    val onClickListener: onPersonalClickListener
    //val onItemSeleted: (Int) -> Unit*/
) : RecyclerView.Adapter<PaisesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PaisesViewHolder(layoutInflater.inflate(R.layout.item_paises, parent, false))
    }

    override fun onBindViewHolder(holder: PaisesViewHolder, position: Int) {
        val item = PaisesList[position]
        holder.render(item, onClickListener)//, onItemSeleted)
    }

    override fun getItemCount(): Int = PaisesList.size
}
