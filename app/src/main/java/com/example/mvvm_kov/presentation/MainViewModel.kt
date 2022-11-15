package com.example.mvvm_kov.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {


    init {
        Log.e("exc", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("exc", "ViewModel cleared")
        super.onCleared()
    }

    fun save(text: String): String {
        val name = SaveUserName(saveName = text)
        val result: Boolean = saveUserNameUseCase.execute(userName = name)
        return "Save result $result"
    }

    fun get(): String {
        val userName: UserName = getUserNameUseCase.execute()
        val result: String = "${userName.firstName} ${userName.lastName}"
        return result
    }


}