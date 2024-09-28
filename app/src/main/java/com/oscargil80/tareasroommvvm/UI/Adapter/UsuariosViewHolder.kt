package com.oscargil80.tareasroommvvm.UI.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.databinding.ItemUsuariosBinding

class UsuariosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemUsuariosBinding.bind(view)

    fun render(
        usuario: Usuarios,
        onClickListener: OnClickInterface
    ) {
        binding.usuarioUs.text = usuario.usuario.toString()
        binding.claveUs.text = usuario.clave.toString()
        binding.descripcionUs.text = usuario.usuario.toString()

    }
}

interface OnClickInterface {
    fun onClickItem(usuario: Usuarios)
    fun onClickDelete(usuario: Usuarios)
}
