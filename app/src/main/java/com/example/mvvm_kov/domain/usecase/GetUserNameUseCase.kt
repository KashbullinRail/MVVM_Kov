package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.UserName

class GetUserNameUseCase {

    fun execute():UserName {
        return UserName(firstName = "Bingo", lastName = "Anim")
    }

}