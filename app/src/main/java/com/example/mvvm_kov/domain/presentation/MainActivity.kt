package com.example.mvvm_kov.domain.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mvvm_kov.R
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val tvGetName: TextView by lazy { findViewById(R.id.tvGetName) }
    private val etPutData: EditText by lazy { findViewById(R.id.etPutName) }
    private val btnGetName: Button by lazy { findViewById(R.id.btnGetName) }
    private val btnSaveData: Button by lazy { findViewById(R.id.btnSaveName) }

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetName.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            tvGetName.text = "${userName.firstName} ${userName.lastName}"

        }

        btnSaveData.setOnClickListener {
            val text = etPutData.text.toString()
            val name = SaveUserName(name = text)
            val result: Boolean = saveUserNameUseCase.execute(userName = name)
            tvGetName.text = "Save result $result"
        }

    }
}