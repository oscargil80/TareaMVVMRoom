package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.usViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentCreateUsuarioBinding
import kotlinx.coroutines.flow.combine


class CreateUsuarioFragment : Fragment() {

    private var _binding : FragmentCreateUsuarioBinding? = null
    val binding get() = _binding!!

    val viewModel :usViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddPersonal.setOnClickListener {
            GuardarUs()
        }
    }

    fun  GuardarUs() {
       val usuario = binding.usSaveUs.text.toString()
       val clave = binding.claveSaveUs.text.toString()
       val descripcion = binding.descripcionSaveUs.text.toString()

        val data = Usuarios(null, usuario, clave, descripcion  )
        viewModel.insertUs(data)

        Navigation.findNavController(requireView()).navigate(R.id.action_createUsuarioFragment_to_homeUsuarioFragment)
        Toast.makeText(requireContext(), "Usuario Guardado Con Exito", Toast.LENGTH_SHORT).show();

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

