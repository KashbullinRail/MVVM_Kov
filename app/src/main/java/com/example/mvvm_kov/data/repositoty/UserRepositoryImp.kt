package com.example.mvvm_kov.data.repositoty

import com.example.mvvm_kov.data.storage.model.User
import com.example.mvvm_kov.data.storage.UserStorage
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository

class UserRepositoryImp(private val userStorage: UserStorage) : UserRepository {



    override fun saveName(saveUserName: SaveUserName): Boolean {

        val user = User(firstName = saveUserName.saveName, lastName = "")

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }

}