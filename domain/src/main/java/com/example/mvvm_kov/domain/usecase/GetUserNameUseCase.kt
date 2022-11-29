package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute():UserName {
        return userRepository.getName()
    }

}