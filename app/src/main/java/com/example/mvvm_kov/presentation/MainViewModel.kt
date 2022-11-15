package com.example.mvvm_kov.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    init {
        Log.e("exc", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("exc", "ViewModel cleared")
        super.onCleared()
    }

}