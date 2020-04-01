package com.example.freelancer.chat

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ChatViewModel : ViewModel() {

    val currentUser = FirebaseAuth.getInstance().currentUser?.uid

}
