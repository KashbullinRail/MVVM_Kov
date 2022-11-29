package com.example.mvvm_kov.di

import com.example.mvvm_kov.data.repositoty.UserRepositoryImp
import com.example.mvvm_kov.data.storage.UserStorage
import com.example.mvvm_kov.data.storage.sharedpref.SharedPrefUserStorage
import com.example.mvvm_kov.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImp(userStorage = get())
    }

}