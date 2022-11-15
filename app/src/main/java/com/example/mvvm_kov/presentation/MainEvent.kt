package com.example.mvvm_kov.presentation

import android.widget.EditText

interface MainEvent

class SaveEvent(val text: String):MainEvent

class GetEvent: MainEvent