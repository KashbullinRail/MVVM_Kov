package com.example.mvvm_kov.di

import dagger.Component


@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
}