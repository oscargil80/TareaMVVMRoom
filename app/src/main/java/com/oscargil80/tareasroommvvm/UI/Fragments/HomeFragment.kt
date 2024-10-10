package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.databinding.FragmentCreateEditBinding
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeBinding
import com.oscargil80.tareasroommvvm.myToolBar


class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    val binding get() = _binding!!

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}