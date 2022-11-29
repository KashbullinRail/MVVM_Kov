package com.example.mvvm_kov.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase


class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}