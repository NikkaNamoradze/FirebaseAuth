package com.example.firebaseauth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firebaseauth.R
import com.example.firebaseauth.databinding.HomePageBinding

class HomeFragment: Fragment(R.layout.home_page) {

    private var _binding: HomePageBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun listeners(){

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFirstRegistrationFragment())
        }

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
        }

    }

}

