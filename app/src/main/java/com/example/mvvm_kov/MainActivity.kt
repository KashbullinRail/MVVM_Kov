package com.example.mvvm_kov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mvvm_kov.domain.usecase.GetUserName
import com.example.mvvm_kov.domain.usecase.SaveUserName

class MainActivity : AppCompatActivity() {

    private val tvGetName:TextView by lazy { findViewById(R.id.tvGetName) }
    private val etPutData:EditText by lazy { findViewById(R.id.etPutName) }
    private val btnGetName:Button by lazy { findViewById(R.id.btnGetName) }
    private val btnSaveData:Button by lazy { findViewById(R.id.btnSaveName) }

    private val getUserName = GetUserName()
    private val saveUserName = SaveUserName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetName.setOnClickListener {

        }

        btnSaveData.setOnClickListener {

        }

    }
}