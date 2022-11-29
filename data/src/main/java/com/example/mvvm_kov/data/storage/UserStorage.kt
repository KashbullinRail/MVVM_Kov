package com.example.mvvm_kov.data.storage

import com.example.mvvm_kov.data.storage.model.User


interface UserStorage {

    fun save(user: User):Boolean

    fun get(): User

}