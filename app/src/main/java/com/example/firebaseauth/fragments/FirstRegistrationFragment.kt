package com.example.firebaseauth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firebaseauth.R
import com.example.firebaseauth.databinding.RegisterFirstPageBinding

class FirstRegistrationFragment: Fragment(R.layout.register_first_page) {

    private var _binding: RegisterFirstPageBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterFirstPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }


    private fun listeners(){
        binding.back.setOnClickListener {
            findNavController().navigate(FirstRegistrationFragmentDirections.actionFirstRegistrationFragmentToHomeFragment())
        }

        binding.btnNext.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            validation(email,password)
        }

    }

    private fun validation(email:String,password:String){

        if (!email.contains("@") && !email.contains(".com")){
            Toast.makeText(context, "შეიყვანეთ მეილი სწორად", Toast.LENGTH_SHORT).show()
        }else if(password.length < 8){
            Toast.makeText(context, "შეიყვანეთ პაროლი სწორად", Toast.LENGTH_SHORT).show()
        }else{
            findNavController().navigate(FirstRegistrationFragmentDirections.actionFirstRegistrationFragmentToSecondRegistrationFragment(email,password))
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}