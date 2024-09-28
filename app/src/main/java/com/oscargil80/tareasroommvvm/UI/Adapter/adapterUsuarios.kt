package com.oscargil80.tareasroommvvm.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.R


class adapterUsuarios(
    var UsuariosList: List<Usuarios>,
    var onClickListener: OnClickInterface
) : RecyclerView.Adapter<UsuariosViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuariosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuariosViewHolder(layoutInflater.inflate(R.layout.item_usuarios, parent, false))
    }

    override fun onBindViewHolder(holder: UsuariosViewHolder, position: Int) {
        val item = UsuariosList[position]
        holder.render(item, onClickListener)//, onItemSeleted)
    }

    override fun getItemCount(): Int = UsuariosList.size
}
