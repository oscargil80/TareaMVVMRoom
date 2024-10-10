package com.oscargil80.tareasroommvvm.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.oscargil80.tareasroommvvm.R
import com.oscargil80.tareasroommvvm.databinding.FragmentCreateEditBinding
import com.oscargil80.tareasroommvvm.myToolBar


class CreateEditFragment : Fragment() {

    private  var _binding:FragmentCreateEditBinding? = null
    val binding get() = _binding!!

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
        myToolBar().show(activ, "Crear Editar Elementos", true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}