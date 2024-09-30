package com.oscargil80.tareasroommvvm.UI.Fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.UI.Adapter.OnClickInterface
import com.oscargil80.tareasroommvvm.UI.Adapter.adapterUsuarios
import com.oscargil80.tareasroommvvm.ViewModel.usViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeUsuarioBinding


class HomeUsuarioFragment : Fragment(), OnClickInterface {

    private var _binding : FragmentHomeUsuarioBinding? = null
    val binding get() = _binding!!

    val viewModel: usViewModel by viewModels()
    lateinit var  adapter : adapterUsuarios

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getAllUs().observe(viewLifecycleOwner){ usList ->
            binding.rvUsuario.layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterUsuarios(usList, this)
            binding.rvUsuario.adapter = adapter
        }

        binding.btnAddUsuario.setOnClickListener {
           Navigation.findNavController(it).navigate(R.id.action_homeUsuarioFragment_to_createUsuarioFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickItem(usuario: Usuarios) {
        val action = HomeUsuarioFragmentDirections.actionHomeUsuarioFragmentToEditUsuarioFragment(usuario)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onClickDelete(id: Int) {
        val builder = AlertDialog.Builder(ContextThemeWrapper(requireContext(), R.style.AlertDialogCustom))
        builder.setPositiveButton("Si"){_,_->
           viewModel.deleteUs(id)
            Toast.makeText(requireContext(), "Usuario Eliminado Con Exito", Toast.LENGTH_SHORT).show();
        }

        builder.setIcon(resources.getDrawable(R.drawable.ic_delete))
        builder.setNegativeButton("No"){_, _ ->}
        builder.setTitle("Borrar Elemento")
        builder.setMessage("Estas Seguro que deseas borrar  este Elemento?")
      //  builder.setNeutralButton("Hola"){_, _ ->}
        builder.create().show()
    }
}