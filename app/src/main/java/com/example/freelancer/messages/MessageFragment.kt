package com.example.freelancer.messages

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.freelancer.R
import com.example.freelancer.databinding.MessageFragmentBinding

class MessageFragment : Fragment() {

    companion object {
        fun newInstance() = MessageFragment()
    }

    private lateinit var viewModel: MessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MessageFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.messageFragmentRecyclerView.apply {
            adapter = MessageAdapter()
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}
