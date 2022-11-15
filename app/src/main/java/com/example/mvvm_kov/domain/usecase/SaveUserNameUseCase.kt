package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(userName: SaveUserName):Boolean {
        val result: Boolean = userRepository.saveName(saveUserName = userName)
        return result
    }

}