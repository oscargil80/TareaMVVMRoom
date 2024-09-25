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
import com.oscargil80.tareasroommvvm.Model.Personal
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PersonalViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentEditPersonBinding


class EditPersonFragment : Fragment() {

    private  var _binding : FragmentEditPersonBinding? = null
    private val binding get() = _binding!!
    val viewModel: PersonalViewModel by viewModels()

    val personal by navArgs<EditPersonFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         _binding = FragmentEditPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cedEditPerson.setText(personal.data.cedula)
        binding.nombreEditPerson.setText(personal.data.nombre)
        binding.dirEditPerson.setText(personal.data.dir)

        binding.btnSavePersonal.setOnClickListener {
            actualizarPersonal()
        }

    }

    private fun actualizarPersonal() {
        val cedula = binding.cedEditPerson.text.toString()
        val nombre = binding.nombreEditPerson.text.toString()
        val direccion = binding.dirEditPerson.text.toString()
        val data = Personal(personal.data.id, cedula, nombre, direccion)

        viewModel.updatePersonal(data)

        Navigation.findNavController(requireView()).navigate(R.id.action_editPersonFragment_to_homeFragment)
        Toast.makeText(requireContext(), "Personal Fue Actualizado Satisfactoriamente", Toast.LENGTH_SHORT).show();
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


