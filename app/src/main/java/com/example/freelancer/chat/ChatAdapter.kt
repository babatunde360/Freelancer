package com.example.freelancer.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.freelancer.databinding.MessageReceivedItemViewBinding
import com.example.freelancer.databinding.MessageSentItemViewBinding
import com.example.freelancer.model.Message

class ChatAdapter(private val currentUser: String) : ListAdapter<Message, RecyclerView.ViewHolder>(DiffCallback) {

    private val VIEW_TYPE_MESSAGE_SENT = 1
    private val VIEW_TYPE_MESSAGE_RECEIVED = 0

    class ReceivedMessageViewHolder(private val binding: MessageReceivedItemViewBinding):
            RecyclerView.ViewHolder(binding.root){
            fun bindReceivedMessage(receivedMessage: Message){
                binding.receivedMessage = receivedMessage
                binding.executePendingBindings()

            }
    }

    class SentMessageViewHolder(private val binding: MessageSentItemViewBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bindSentMessage(sentMessage: Message){
            binding.sentMessage = sentMessage
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback:DiffUtil.ItemCallback<Message>(){
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return if(viewType == VIEW_TYPE_MESSAGE_SENT){
            val binding = MessageSentItemViewBinding.inflate(layoutInflater)
            SentMessageViewHolder(binding)
        }else{
            val binding = MessageReceivedItemViewBinding.inflate(layoutInflater)
            ReceivedMessageViewHolder(binding)
            }
        }

    override fun getItemViewType(position: Int): Int {
        val currentMessage = getItem(position)
        return if(currentMessage.sender == currentUser){
            VIEW_TYPE_MESSAGE_SENT
        }else {
            VIEW_TYPE_MESSAGE_RECEIVED
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
     val currentMessage = getItem(position)
        when(holder.itemViewType){
            VIEW_TYPE_MESSAGE_SENT ->{
                val messageSentHolder = holder as SentMessageViewHolder
                messageSentHolder.bindSentMessage(currentMessage)
            }
            VIEW_TYPE_MESSAGE_RECEIVED ->{
                val messageReceivedHolder = holder as ReceivedMessageViewHolder
                messageReceivedHolder.bindReceivedMessage(currentMessage)
            }
        }
    }

}