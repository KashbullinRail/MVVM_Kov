package com.example.mvvm_kov.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mvvm_kov.R
import com.example.mvvm_kov.data.repositoty.UserRepositoryImp
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

    private val userRepository = UserRepositoryImp()
    private val getUserNameUseCase = GetUserNameUseCase(userRepository = userRepository)
    private val saveUserNameUseCase = SaveUserNameUseCase(userRepository = userRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetName.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            tvGetName.text = "${userName.firstName} ${userName.lastName}"

        }

        btnSaveData.setOnClickListener {
            val text = etPutData.text.toString()
            val name = SaveUserName(saveName = text)
            val result: Boolean = saveUserNameUseCase.execute(userName = name)
            tvGetName.text = "Save result $result"
        }

    }
}