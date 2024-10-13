package com.oscargil80.tareasroommvvm.UI.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.UI.Adapter.OnClickEvent
import com.oscargil80.tareasroommvvm.UI.Adapter.PaisesAdapter
import com.oscargil80.tareasroommvvm.ViewModel.PaisesViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentCreateEditBinding
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeBinding
import com.oscargil80.tareasroommvvm.myToolBar


class HomeFragment : Fragment(), OnClickEvent {

    private var _binding:FragmentHomeBinding? = null
    val binding get() = _binding!!

    val ViewModel: PaisesViewModel by viewModels()
    lateinit var adapter: PaisesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var activ: AppCompatActivity = requireActivity() as AppCompatActivity

        myToolBar().show(activ, "Listado de Elementos ", false)

        binding.btnAdd.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_createEditFragment)
        }

        ViewModel.getAllPaises().observe(viewLifecycleOwner){ paises ->
            setRecyclerView(paises)
        }
    }

    private fun setRecyclerView(paises: List<Paises>) {

        binding.rvPaises.layoutManager = LinearLayoutManager(requireContext())
        adapter = PaisesAdapter(paises, this)
        binding.rvPaises.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickItem(pais: Paises) {
        val action =
            pais.id?.let { id->
                HomeFragmentDirections.actionHomeFragmentToCreateEditFragment(1, id)
            }
        if (action != null) {
            Navigation.findNavController(requireView()).navigate(action)
        }
    }

    override fun onClickDelete(pais: Paises) {
        val builder =
            AlertDialog.Builder(ContextThemeWrapper(requireContext(), R.style.AlertDialogCustom))
        with(builder) {
            setPositiveButton("SI") { _, _ ->
                ViewModel.deletePais(pais)
                Toast.makeText(requireContext(), "Pais Borrado Con Exito", Toast.LENGTH_SHORT).show();
            }
            setNegativeButton("NO") { _, _ -> }
            setTitle("Borrar Pais")
            setMessage("Estas Seguro que Desea Eliminar Este Pais")
            create().show()
        }
    }
}