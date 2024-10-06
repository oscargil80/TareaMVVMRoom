package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.FamilyViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentCreateFamilyBinding


class CreateFamilyFragments : Fragment() {

    private var _binding : FragmentCreateFamilyBinding? = null
    val binding get() = _binding!!
    val viewModel : FamilyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddFamily.setOnClickListener {
            GuardarFamily()
        }
    }

    private fun GuardarFamily() {
        val paren = binding.parenCreate.text.toString()
        val nombre = binding.nombreCreate.text.toString()
        val apellido = binding.apellidoCreate.text.toString()

        val data = Family(
            null, paren,  nombre, apellido
        )

        viewModel.insertFamily(data)
        Toast.makeText(requireContext(), "Familia Agregada Con Exito", Toast.LENGTH_SHORT).show();
        Navigation.findNavController(requireView()).navigate(R.id.action_createFamilyFragments_to_homeFamilyFragments)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}