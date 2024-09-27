package com.oscargil80.tareasroommvvm.ui.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PaisesViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentInicioBinding
import com.oscargil80.tareasroommvvm.ui.Adapter.PaisesAdapter


class InicioFragent : Fragment() {

    private var _binding : FragmentInicioBinding? = null
    private val binding get() = _binding!!
     val viewModel:PaisesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        viewModel.getAllPersonal().observe(viewLifecycleOwner) { personalList ->
            binding.rvPersonal.layoutManager = LinearLayoutManager(requireContext())
            adapter = PersonalAdapter(personalList, this)
            binding.rvPersonal.adapter = adapter
        }*/




        viewModel.getPaises().observe(viewLifecycleOwner){   paisesList->
            binding.rvPaises.layoutManager = LinearLayoutManager(requireContext())
            val adapter = PaisesAdapter(paisesList)
            binding.rvPaises.adapter = adapter
        }



        binding.addPaises.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_inicioFragent_to_crearFragment)
        }
    }

   /* private fun setRecyclerView(paisesList: List<Paises>) {

    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}