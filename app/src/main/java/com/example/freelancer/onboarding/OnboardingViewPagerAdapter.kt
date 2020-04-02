package com.example.freelancer.onboarding

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.freelancer.signup.SignUpFragment


class OnboardingViewPagerAdapter(fragment: Fragment)
    :FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){

            0->{
                OnboardingFragmenTwo()
            }
            1->{
                OnboardingFragmentThree()
            }
            2->{
                OnboardingFragmentFour()
            }
            3->{
                OnboardingFragmentFive()
            }
            4->{
                OnBoardingFragmentSix()
            }
            5->{
                SignUpFragment()
            }else->{
                SignUpFragment()
            }
        }

    }

}