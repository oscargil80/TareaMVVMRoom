package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.databinding.FragmentHomeFamilyBinding

class HomeFamilyFragments : Fragment() {

    private var _binding : FragmentHomeFamilyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         _binding = FragmentHomeFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnAddPersonal.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_homeFamilyFragments_to_createFamilyFragments)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}