package com.example.freelancer.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.freelancer.R
import com.example.freelancer.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel
private lateinit var binding: FragmentSignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        viewModel.isAuthenticated.observe(this, Observer {
            if (it == true){
                findNavController().navigate(R.id.action_signInFragment_to_nav_home)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.signUpEmail.observe(viewLifecycleOwner, Observer {
            it.plus(binding.signInEmail)
        })
        viewModel.signUpPassword.observe(viewLifecycleOwner, Observer {
            it.plus(binding.signInPassword)
        })

        binding.signInButton.setOnClickListener {
            viewModel.signIn()
            if (viewModel.toastMessage.value != null) {
                Toast.makeText(context, viewModel.toastMessage.value.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.signUpTextView.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
