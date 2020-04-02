package com.example.freelancer.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.freelancer.R
import com.example.freelancer.databinding.FragmentSignUpBinding
import com.example.freelancer.signin.SignInViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {

private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        viewModel.isAuthenticated.observe(this, Observer {
            if (it == true){
                findNavController().navigate(R.id.action_signUpFragment_to_nav_home)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        navView?.visibility = View.GONE
         binding = FragmentSignUpBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.signUpFirstName.observe(viewLifecycleOwner, Observer {
            it.plus(binding.firstNameEditText)
        })
        viewModel.signUpLastName.observe(viewLifecycleOwner, Observer {
            it.plus(binding.lastNameEditText)
        })
        viewModel.signUpEmail.observe(viewLifecycleOwner, Observer {
            it.plus(binding.emailEditText)
        })
        viewModel.signUpPassword.observe(viewLifecycleOwner, Observer {
            it.plus(binding.passwordEditText)
        })

        binding.signInButton.setOnClickListener {
            viewModel.createAccount()
            Toast.makeText(context,viewModel.toastMessage.value.toString(),Toast.LENGTH_SHORT).show()
        }

        binding.goToSignin.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signInFragment)
        }

    }
}

