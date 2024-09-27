package com.oscargil80.tareasroommvvm.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PaisesViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentEditarBinding


class EditarFragment : Fragment() {

    private var _binding : FragmentEditarBinding? = null
    private val binding get() = _binding!!
    val paisArgs by navArgs<EditarFragmentArgs>()
    val viewModel : PaisesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.codigoPaisEdit.setText(paisArgs.paisArgs.codigoPais)
        binding.nombrePaisEdit.setText(paisArgs.paisArgs.nombrePais)
        binding.ContinentePaisEdit.setText(paisArgs.paisArgs.continentePais)

        binding.btnEditPaises.setOnClickListener {
            updatePaises()
        }

    }

    private fun updatePaises() {
        val codigoPais = binding.codigoPaisEdit.text.toString()
        val nombrePais = binding.nombrePaisEdit.text.toString()
        val continentePais = binding.ContinentePaisEdit.text.toString()

        val data = Paises(
            paisArgs.paisArgs.id,
            codigoPais,
            nombrePais,
            continentePais
        )
        viewModel.updatePaises(data)
        Navigation.findNavController(requireView()).navigate(R.id.action_editarFragment_to_inicioFragent)
        Toast.makeText(requireContext(), "Pais Actualizado con exito", Toast.LENGTH_SHORT).show();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}