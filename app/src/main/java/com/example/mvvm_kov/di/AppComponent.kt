package com.example.mvvm_kov.di

import com.example.mvvm_kov.presentation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}