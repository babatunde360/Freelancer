package com.example.freelancer.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.freelancer.R
import com.example.freelancer.databinding.OnboardingFragmentBinding
import com.example.freelancer.signin.SignInViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingFragment : Fragment() {

    companion object {
        fun newInstance() = OnboardingFragment()
    }

    private lateinit var viewModel: SignInViewModel
    private lateinit var binding: OnboardingFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        viewModel.isAuthenticated.observe(this, Observer {
            if (it == true){
                findNavController().navigate(R.id.action_onboardingFragment_to_nav_home)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        navView?.visibility = View.GONE
         binding = OnboardingFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.obBoardingViewPager.adapter = OnboardingViewPagerAdapter(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        TabLayoutMediator(binding.onBoardingTab,binding.obBoardingViewPager){ _, _ ->
        }.attach()
    }
}
