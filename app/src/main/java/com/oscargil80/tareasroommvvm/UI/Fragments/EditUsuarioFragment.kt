package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.usViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentEditUsuarioBinding


class EditUsuarioFragment : Fragment() {

    private var _binding : FragmentEditUsuarioBinding? = null
    private val binding get() = _binding!!
    val viewModel : usViewModel by viewModels()

    val usus by navArgs<EditUsuarioFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usEditUsuario.setText(usus.data.usuario)
        binding.claveEditUsuario.setText(usus.data.clave)
        binding.descripcionEditUsuario.setText(usus.data.descripcion)

        binding.btnEditPersonal.setOnClickListener {
            updateUs()
        }
    }

    private fun updateUs() {
        val usuario = binding.usEditUsuario.text.toString()
        val clave  = binding.claveEditUsuario.text.toString()
        val desc = binding.descripcionEditUsuario.text.toString()

        val data = Usuarios(usus.data.id, usuario, clave, desc)
         viewModel.updateUs(data)
        Navigation.findNavController(requireView()).navigate(R.id.action_editUsuarioFragment_to_homeUsuarioFragment)
        Toast.makeText(requireContext(), "Registro Actualidado Con Exito", Toast.LENGTH_SHORT).show();


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}