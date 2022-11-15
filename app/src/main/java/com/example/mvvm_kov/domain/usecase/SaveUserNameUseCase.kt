package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.SaveUserName

class SaveUserNameUseCase {

    fun execute(userName: SaveUserName):Boolean {
        if(userName.name.isEmpty()){
            return false
        } else {
            return true
        }
    }

}