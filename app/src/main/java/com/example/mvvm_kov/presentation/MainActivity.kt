package com.example.mvvm_kov.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_kov.R
import com.example.mvvm_kov.data.repositoty.UserRepositoryImp
import com.example.mvvm_kov.data.storage.sharedpref.SharedPrefUserStorage
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val tvGetName: TextView by lazy { findViewById(R.id.tvGetName) }
    private val etPutData: EditText by lazy { findViewById(R.id.etPutName) }
    private val btnGetName: Button by lazy { findViewById(R.id.btnGetName) }
    private val btnSaveData: Button by lazy { findViewById(R.id.btnSaveName) }


    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("exc", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        vm.getResultLiveData().observe(this, Observer {
            tvGetName.text = it
        })

        btnGetName.setOnClickListener {
            vm.get()
        }

        btnSaveData.setOnClickListener {
            val text = etPutData.text.toString()
            vm.save(text)
        }

    }
}