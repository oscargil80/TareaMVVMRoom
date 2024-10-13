package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PaisesViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentCreateEditBinding
import com.oscargil80.tareasroommvvm.myToolBar


class CreateEditFragment : Fragment() {

    private  var _binding:FragmentCreateEditBinding? = null
    val binding get() = _binding!!

    val viewModel: PaisesViewModel by viewModels()
    val paisArgs by navArgs<CreateEditFragmentArgs>()

    lateinit var nombre: String;     lateinit var capital: String ;   lateinit var continente: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var activ:AppCompatActivity = requireActivity() as AppCompatActivity

        if (paisArgs.typeActions==1){
            CargarDatos(paisArgs.idPais)
            myToolBar().show(activ, "Editar Pais", true)
        } else if(paisArgs.typeActions== 0)
            myToolBar().show(activ, "Crear Pais", true)

        binding.btnAddEdit.setOnClickListener {
            guardarPais(paisArgs.idPais)
        }
    }


    private fun CargarDatos(idPais: Int) {
        viewModel.getPaisById(idPais).observe(viewLifecycleOwner) {   paises->
            binding.nombrePais.setText(paises.nombre)
            binding.capitalPais.setText(paises.capital)
            binding.contiPais.setText(paises.continente)
        }
    }

    private fun guardarPais(idPais: Int) {
        var id : Int? = idPais
        if(id==-1)  id = null
        nombre = binding.nombrePais.text.toString()
        capital = binding.capitalPais.text.toString()
        continente = binding.contiPais.text.toString()
        val data = Paises(id, nombre, capital, continente)
        viewModel.insertPais(data)
        Navigation.findNavController(requireView()).navigate(R.id.action_createEditFragment_to_homeFragment)
        Toast.makeText(requireContext(), "Pais Agregado Con exito", Toast.LENGTH_SHORT).show()
    }

   /* private fun updatePais(idPais: Int) {
        nombre = binding.nombrePais.text.toString()
        capital = binding.capitalPais.text.toString()
        continente = binding.contiPais.text.toString()
        val data = Paises(idPais, nombre, capital, continente)
        viewModel.updatePais(data)
        Navigation.findNavController(requireView()).navigate(R.id.action_createEditFragment_to_homeFragment)
        Toast.makeText(requireContext(), "Pais Actualizado Con exito", Toast.LENGTH_SHORT).show();
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}