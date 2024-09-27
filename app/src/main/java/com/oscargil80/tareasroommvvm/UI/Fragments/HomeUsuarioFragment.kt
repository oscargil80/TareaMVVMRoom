package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeUsuarioBinding


class HomeUsuarioFragment : Fragment() {

    private var _binding : FragmentHomeUsuarioBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddUsuario.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeUsuarioFragment_to_createUsuarioFragment)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}