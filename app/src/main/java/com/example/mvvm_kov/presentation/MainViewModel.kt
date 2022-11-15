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

    private val stateLiveDataMutable = MutableLiveData<MainState>()
    val stateLiveData: LiveData<MainState> = stateLiveDataMutable

    init {
        Log.e("exc", "ViewModel created")
        stateLiveDataMutable.value = MainState(saveResult = false, firsName = "", lastName = "")
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
        stateLiveDataMutable.value =
            MainState(
                saveResult = resultData,
                firsName = stateLiveData.value!!.firsName,
                lastName = stateLiveData.value!!.lastName
            )
    }

    private fun get() {
        val userName: UserName = getUserNameUseCase.execute()
        stateLiveDataMutable.value = MainState(
            saveResult = stateLiveData.value!!.saveResult,
            firsName = userName.firstName,
            lastName = userName.lastName
        )

    }


}