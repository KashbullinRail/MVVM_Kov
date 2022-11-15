package com.example.mvvm_kov.domain.repository

import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName

interface UserRepository {

    fun saveName(saveUserName: SaveUserName): Boolean

    fun getName(): UserName

}