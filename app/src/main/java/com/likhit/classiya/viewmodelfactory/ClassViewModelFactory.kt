package com.likhit.classiya.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.likhit.classiya.viewmodel.ClassViewModel

class ClassViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClassViewModel::class.java)) {
            return ClassViewModel() as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}