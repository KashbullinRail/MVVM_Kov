package com.example.mvvm_kov.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_kov.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val tvGetName: TextView by lazy { findViewById(R.id.tvGetName) }
    private val etPutData: EditText by lazy { findViewById(R.id.etPutName) }
    private val btnGetName: Button by lazy { findViewById(R.id.btnGetName) }
    private val btnSaveData: Button by lazy { findViewById(R.id.btnSaveName) }

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("exc", "Activity created")

        vm.resultLiveData.observe(this, Observer {
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