package com.example.freelancer.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.freelancer.R
import com.example.freelancer.databinding.OnboardingScreen1Binding
import com.example.freelancer.signin.SignInViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class OnboardingFragmentOne: Fragment() {
    lateinit var binding:OnboardingScreen1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        viewModel.isAuthenticated.observe(this, Observer {
            if (it == true){
                findNavController().navigate(R.id.action_onboardingFragmentOne_to_nav_home)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        navView?.visibility = View.GONE
        binding = OnboardingScreen1Binding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.onboardingButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragmentOne_to_onboardingFragment)
        }
        binding.toToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragmentOne_to_signInFragment)
        }
    }
}