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
import com.example.mvvm_kov.app.App
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val tvGetName: TextView by lazy { findViewById(R.id.tvGetName) }
    private val etPutData: EditText by lazy { findViewById(R.id.etPutName) }
    private val btnGetName: Button by lazy { findViewById(R.id.btnGetName) }
    private val btnSaveData: Button by lazy { findViewById(R.id.btnSaveName) }

    private lateinit var vm :MainViewModel
    @Inject
    lateinit var vmFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("exc", "Activity created")

        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)


        vm.stateLiveData.observe(this) { state ->
            tvGetName.text = "${state.firsName} ${state.lastName} ${state.saveResult}"
        }

        btnGetName.setOnClickListener {
            vm.send(GetEvent())
        }

        btnSaveData.setOnClickListener {
            val text = etPutData.text.toString()
            vm.send(SaveEvent(text = text))
        }

    }

}