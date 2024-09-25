package com.oscargil80.tareasroommvvm.ui.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.tareasroommvvm.Model.Personal
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.ViewModel.PersonalViewModel
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeBinding
import com.oscargil80.tareasroommvvm.ui.Adapter.OnPersonalClickListener
import com.oscargil80.tareasroommvvm.ui.Adapter.PersonalAdapter


class HomeFragment : Fragment(), OnPersonalClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val viewModel: PersonalViewModel by viewModels()
    lateinit var adapter: PersonalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllPersonal().observe(viewLifecycleOwner) { personalList ->
           binding.rvPersonal.layoutManager = LinearLayoutManager(requireContext())
            adapter = PersonalAdapter(personalList, this)
            binding.rvPersonal.adapter = adapter
        }

        binding.btnAddPersonal.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createPersonFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onImageClick(id: Int) {
        viewModel.deletePersonal(id)
        Toast.makeText(requireContext(), "Elemento Eliminado con exito", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged()
    }

    override fun onItemClick(personal: Personal) {
        val action = HomeFragmentDirections.actionHomeFragmentToEditPersonFragment(personal)
        Navigation.findNavController(requireView()).navigate(action)
    }
}