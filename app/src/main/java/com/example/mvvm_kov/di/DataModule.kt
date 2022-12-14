package com.example.mvvm_kov.di

import android.content.Context
import com.example.mvvm_kov.data.repositoty.UserRepositoryImp
import com.example.mvvm_kov.data.storage.UserStorage
import com.example.mvvm_kov.data.storage.sharedpref.SharedPrefUserStorage
import com.example.mvvm_kov.domain.repository.UserRepository
import dagger.Module
import dagger.Provides


@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImp(userStorage = userStorage)
    }

}