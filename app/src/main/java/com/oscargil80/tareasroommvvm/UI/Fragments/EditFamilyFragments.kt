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
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.FamilyViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentEditFamilyBinding


class EditFamilyFragments : Fragment() {

    private var _binding: FragmentEditFamilyBinding? = null
    private val binding get() = _binding!!

    val viewModel : FamilyViewModel by viewModels()
    val familyArgs by navArgs<EditFamilyFragmentsArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditFamilyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.parenEdit.setText(familyArgs.data.parentesco)
        binding.nombreEdit.setText(familyArgs.data.nombre)
        binding.apellidoEdit.setText(familyArgs.data.apellido)

        binding.btnUpdateFamily.setOnClickListener {
            updateFamily()
        }

    }

    private fun updateFamily() {
        val paren = binding.parenEdit.text.toString()
        val nombre = binding.nombreEdit.text.toString()
        val apellido = binding.apellidoEdit.text.toString()

        val data = Family(
            familyArgs.data.id, paren,  nombre, apellido,
        )

        viewModel.updateFamily(data)
        Navigation.findNavController(requireView()).navigate(R.id.action_editFamilyFragments_to_homeFamilyFragments)
        Toast.makeText(requireContext(), "Registro Actualizado Con Exito", Toast.LENGTH_SHORT).show();

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}