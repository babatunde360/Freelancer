package com.example.freelancer.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.freelancer.databinding.OnboardingScreen5Binding

class OnboardingFragmentFive: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = OnboardingScreen5Binding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}