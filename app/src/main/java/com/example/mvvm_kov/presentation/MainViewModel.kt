package com.example.mvvm_kov.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultLiveData = MutableLiveData<String>()

    init {
        Log.e("exc", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("exc", "ViewModel cleared")
        super.onCleared()
    }

    fun getResultLiveData(): LiveData<String> {
        return resultLiveData
    }

    fun save(text: String) {
        val name = SaveUserName(saveName = text)
        val resultData: Boolean = saveUserNameUseCase.execute(userName = name)
        resultLiveData.value = "Save result $resultData"
    }

    fun get() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveData.value = "${userName.firstName} ${userName.lastName}"

    }


}