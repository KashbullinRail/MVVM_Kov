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

    private val resultLiveDataMutable = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultLiveDataMutable

    init {
        Log.e("exc", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("exc", "ViewModel cleared")
        super.onCleared()
    }

    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> {
                save(text = event.text)
            }
            is GetEvent -> {
                get()
            }
        }
    }

    private fun save(text: String) {
        val name = SaveUserName(saveName = text)
        val resultData: Boolean = saveUserNameUseCase.execute(userName = name)
        resultLiveDataMutable.value = "Save result $resultData"
    }

    private fun get() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveDataMutable.value = "${userName.firstName} ${userName.lastName}"

    }


}