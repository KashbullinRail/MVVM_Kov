package com.example.mvvm_kov.app

import android.app.Application
import com.example.mvvm_kov.di.AppComponent
import com.example.mvvm_kov.di.AppModule
import com.example.mvvm_kov.di.DaggerAppComponent


class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }

}