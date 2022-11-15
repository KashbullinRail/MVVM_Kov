package com.example.mvvm_kov.data.repositoty

import android.content.Context
import com.example.mvvm_kov.data.DEFAULT_NAME
import com.example.mvvm_kov.data.KEY_FIRST_NAME
import com.example.mvvm_kov.data.KEY_LAST_NAME
import com.example.mvvm_kov.data.SHARED_PREF_NAME
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository

class UserRepositoryImp(context: Context) : UserRepository {

    private val sharedPreferences = context
        .getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveUserName: SaveUserName): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveUserName.saveName).apply()
        return true
    }

    override fun getName(): UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }

}