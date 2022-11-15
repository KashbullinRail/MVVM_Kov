package com.example.mvvm_kov.data.repositoty

import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository

class UserRepositoryImp: UserRepository {

    override fun saveName(saveUserName: SaveUserName): Boolean {
        return true
    }

    override fun getName():UserName{
        return UserName(firstName = "Rara", lastName = "Disney")
    }

}