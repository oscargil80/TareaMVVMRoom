package com.oscargil80.tareasroommvvm.UI.Fragments


import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.oscargil80.tareasroommvvm.MainActivity
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.MyToolbar
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.FamilyViewModel
import com.oscargil80.tareasroommvvm.databinding.ActivityMainBinding
import com.oscargil80.tareasroommvvm.databinding.FragmentEditFamilyBinding


class EditFamilyFragments : Fragment() {

    private var _binding: FragmentEditFamilyBinding? = null
    private val binding get() = _binding!!
    //lateinit var binding2: ActivityMainBinding


    val viewModel: FamilyViewModel by viewModels()
    val familyArgs by navArgs<EditFamilyFragmentsArgs>()

    lateinit var paren:String
    lateinit var nombre:String
    lateinit var apellido:String
    lateinit var navController: NavController



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditFamilyBinding.inflate(inflater, container, false)

        return binding.root
    }
  //  supportActionBar?
   // supportActionBar

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      //  val toolBar = requireActivity().findViewById<Toolbar>(R.id.toolbaR)
              //Si es para actulizar
        if (familyArgs.typeActions == 1) {
            cargarDatos(familyArgs.familyId)
            MyToolbar().show(requireActivity() as AppCompatActivity, "Actualizar Familia", true)
        }else if (familyArgs.typeActions== 0){
            MyToolbar().show(requireActivity() as AppCompatActivity, "Guardar Familia", true)
        }


        binding.btnUpdateFamily.setOnClickListener {
            if (familyArgs.typeActions == 0) guardarFamily()
            else if (familyArgs.typeActions == 1) updateFamily()
        }
    }

    private fun cargarDatos(familyId: Int) {
        viewModel.getFamById(familyId).observe(viewLifecycleOwner) { family ->
            binding.parenEdit.setText(family.parentesco)
            binding.nombreEdit.setText(family.nombre)
            binding.apellidoEdit.setText(family.apellido)
        }
    }

    private fun guardarFamily() {
         paren = binding.parenEdit.text.toString()
         nombre = binding.nombreEdit.text.toString()
         apellido = binding.apellidoEdit.text.toString()

        val data = Family(
            null, paren, nombre, apellido
        )

        viewModel.insertFamily(data)
        Toast.makeText(requireContext(), "Familia Agregada Con Exito", Toast.LENGTH_SHORT).show();
        Navigation.findNavController(requireView()).navigate(R.id.action_editFamilyFragments_to_homeFamilyFragments)
        MyToolbar().show(requireActivity() as AppCompatActivity, "Listado Familia", false)
    }

    private fun updateFamily() {
         paren = binding.parenEdit.text.toString()
         nombre = binding.nombreEdit.text.toString()
         apellido = binding.apellidoEdit.text.toString()

        val data = Family(
            familyArgs.familyId, paren, nombre, apellido
        )

        viewModel.updateFamily(data)
        Navigation.findNavController(requireView())
            .navigate(R.id.action_editFamilyFragments_to_homeFamilyFragments)

        MyToolbar().show(requireActivity() as AppCompatActivity, "Listado Familia", false)
        Toast.makeText(requireContext(), "Registro Actualizado Con Exito", Toast.LENGTH_SHORT)
            .show();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}