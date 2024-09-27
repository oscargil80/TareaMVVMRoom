package com.oscargil80.tareasroommvvm.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PaisesViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentCrearBinding


class CrearFragment : Fragment() {

    private var _binding: FragmentCrearBinding? = null
    private val binding get() = _binding!!

    val viewModel: PaisesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveNotes.setOnClickListener {
                crearPaises()
        }

    }

    private fun crearPaises() {
        val codigoPais = binding.codigoPaisAdd.text.toString()
        val nombrePais = binding.nombrePaisAdd.text.toString()
        val continentePais = binding.continentePaisAdd.text.toString()

        val data = Paises(
            null,
            codigoPais,
            nombrePais,
            continentePais
        )
        viewModel.addPaises(data)
        Toast.makeText(requireContext(), "Pais Creado con exito", Toast.LENGTH_SHORT).show();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}