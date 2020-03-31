package com.example.freelancer.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.freelancer.messages.MessageAdapter
import com.example.freelancer.model.User

@BindingAdapter("chatData")
fun bindMessages(rv: RecyclerView, data: List<User>){
    val adapter = rv.adapter as MessageAdapter
    adapter.submitList(data)
}