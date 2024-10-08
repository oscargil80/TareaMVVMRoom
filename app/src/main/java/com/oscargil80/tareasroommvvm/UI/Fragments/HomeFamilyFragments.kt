package com.oscargil80.tareasroommvvm.UI.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.MyToolbar
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.UI.Adapter.OnItemSelected
import com.oscargil80.tareasroommvvm.UI.Adapter.adapterFamily
import com.oscargil80.tareasroommvvm.ViewModel.FamilyViewModel
import com.oscargil80.tareasroommvvm.databinding.ActivityMainBinding
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeFamilyBinding


class HomeFamilyFragments : Fragment(), OnItemSelected {

    private var _binding: FragmentHomeFamilyBinding? = null
    private lateinit var binding2: ActivityMainBinding
    private val binding get() = _binding!!
    val viewModel: FamilyViewModel by viewModels()
    lateinit var adapter: adapterFamily



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }
 // it.supportActionBar?.setTitle("Holaaaa")



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var activ:AppCompatActivity = requireActivity() as AppCompatActivity

        MyToolbar().show(activ, "Listado", false)






      /* var bot = (activity as? MainActivity)?.binding?.hi
        bot?.text = "Hola"*/

     /*   binding2.boton.setOnClickListener {
            Toast.makeText(activ, "Hola lo aprestate estando en e, home", Toast.LENGTH_SHORT).show();
        }*/
        viewModel.getAllFamily().observe(viewLifecycleOwner) { familyList ->
            setRecyclewView(familyList)
        }

       // activ.supportActionB
        binding.btnAddPersonal.setOnClickListener {
            val action =    HomeFamilyFragmentsDirections.actionHomeFamilyFragmentsToEditFamilyFragments(  0,  -1  )
                Navigation.findNavController(requireView()).navigate(action)
        }
    }

    private fun setRecyclewView(familyList: List<Family>) {
        val list = familyList.sortedBy {
            with(it) {
                parentesco
                nombre.uppercase()
            }
        }
        binding.rvPersonal.layoutManager = LinearLayoutManager(requireContext())
        adapter = adapterFamily(list, this)
        binding.rvPersonal.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemView(family: Family) {
        val action =
            family.id?.let {id->
                HomeFamilyFragmentsDirections.actionHomeFamilyFragmentsToEditFamilyFragments(  1,  id  )
            }
        if (action != null) {
            Navigation.findNavController(requireView()).navigate(action)
        }
    }

    override fun onDeleteView(id: Int) {
        val builder =
            AlertDialog.Builder(ContextThemeWrapper(requireContext(), R.style.AlertDialogCustom))
        with(builder) {
            setPositiveButton("SI") { _, _ ->
                viewModel.deleteFamily(id)
                Toast.makeText(requireContext(), "Esta es la family ${id}", Toast.LENGTH_SHORT)
                    .show();
            }
            setNegativeButton("NO") { _, _ -> }
            setTitle("Borrar Elemento")
            setMessage("Estas Seguro que Desea Eliminar Al Familiar")
            create().show()
        }

    }
}