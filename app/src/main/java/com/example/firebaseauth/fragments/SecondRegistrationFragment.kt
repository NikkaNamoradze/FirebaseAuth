package com.example.firebaseauth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firebaseauth.R
import com.example.firebaseauth.databinding.RegisterSecondPageBinding
import com.google.firebase.auth.FirebaseAuth

class SecondRegistrationFragment : Fragment(R.layout.register_second_page) {

    private var _binding: RegisterSecondPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterSecondPageBinding.inflate(inflater, container, false)
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

    private fun listeners() {

        binding.back.setOnClickListener {
            findNavController().navigate(SecondRegistrationFragmentDirections.actionSecondRegistrationFragmentToFirstRegistrationFragment())
        }
        binding.btnSignUp.setOnClickListener {
            val username = binding.etUsername.text.toString()
            validation(username)
        }

    }

    private fun validation(username: String) {
        if (username.length < 10) {
            Toast.makeText(context, "შეიყვანეთ მომხმარებლის სახელი სწორად", Toast.LENGTH_SHORT).show()
        } else {

            val email = SecondRegistrationFragmentArgs.fromBundle(requireArguments()).userEmail
            val password = SecondRegistrationFragmentArgs.fromBundle(requireArguments()).userPassword

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(context, "თქვენ წარმატებით დარეგისტრირდით", Toast.LENGTH_SHORT).show()

                        findNavController().navigate(SecondRegistrationFragmentDirections.actionSecondRegistrationFragmentToLoginFragment())
                    }else{
                        Toast.makeText(context, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                    }

                }


        }
    }

}