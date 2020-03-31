package com.example.freelancer.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.freelancer.databinding.MessageItemViewBinding
import com.example.freelancer.model.User

class MessageAdapter: ListAdapter<User, MessageAdapter.MessageViewHolder>(DiffCallback) {

    class MessageViewHolder(val binding: MessageItemViewBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(currentUser: User){
            binding.user = currentUser
            binding.executePendingBindings()
        }
    }

companion object DiffCallback:DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.username == newItem.username
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MessageItemViewBinding.inflate(layoutInflater)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentUser = getItem(position)
        holder.bind(currentUser)

    }

}