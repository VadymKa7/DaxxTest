package com.vadym.daxxtest.ui.child

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NestedViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Open Nested Fragment"
    }
    val text: LiveData<String> = _text
}