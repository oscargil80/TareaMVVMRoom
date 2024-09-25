package com.oscargil80.tareasroommvvm.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Personal
import com.oscargil80.tareasroommvvm.R


class PersonalAdapter(
    var PersonalList: List<Personal>,
    val onClickListener: OnPersonalClickListener

) : RecyclerView.Adapter<PersonalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonalViewHolder(layoutInflater.inflate(R.layout.item_personal, parent, false))
    }

    override fun onBindViewHolder(holder: PersonalViewHolder, position: Int) {
        val item = PersonalList[position]
        holder.render(item, onClickListener)//, onClickListener, onItemSeleted)
    }

    override fun getItemCount(): Int = PersonalList.size
}
