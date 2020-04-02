package com.example.freelancer.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.freelancer.databinding.OnboardingScreen4Binding


class OnboardingFragmentFour: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = OnboardingScreen4Binding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}