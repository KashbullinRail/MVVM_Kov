package com.example.mvvm_kov.di

import android.content.Context
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase
import com.example.mvvm_kov.presentation.MainViewModelFactory
import dagger.Module


@Module
class AppModule(val context: Context) {

    fun provideContext(): Context {
        return context
    }

    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }

}