package com.oscargil80.tareasroommvvm.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.oscargil80.tareasroommvvm.Model.Personal
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PersonalViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentCreatePersonBinding

class CreatePersonFragment : Fragment() {

    private var _binding: FragmentCreatePersonBinding? = null
    private val binding get() = _binding!!
    val  viewModel :PersonalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCreatePersonBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddPersonal.setOnClickListener {
            createPersonal()
        }
    }

    private fun createPersonal() {
        val cedula = binding.cedSavePersonal.text.toString()
        val nombre = binding.nombreSavePersonal.text.toString()
        val direccion = binding.direccionSavePersonal.text.toString()
         val data = Personal(null, cedula, nombre, direccion)

        viewModel.insertPersonal(data)

        Navigation.findNavController(requireView()).navigate(R.id.action_createPersonFragment_to_homeFragment)
        Toast.makeText(requireContext(), "Personal Fue Creado Satisfactoriamente", Toast.LENGTH_SHORT).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}