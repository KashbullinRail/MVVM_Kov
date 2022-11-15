package com.example.mvvm_kov.data.storage


interface UserStorage {

    fun save(user: User):Boolean

    fun get():User

}