package com.example.freelancer.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.freelancer.databinding.OnboardingScreen3Binding

class OnboardingFragmentThree: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = OnboardingScreen3Binding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}