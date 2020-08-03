package com.likhit.classiya.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.likhit.classiya.data.Classe
import com.likhit.classiya.data.getClassesList
import com.likhit.classiya.data.getSubjectsList

/**
 * ViewModel for getting data for home Activity.
 */
class ClassViewModel : ViewModel() {

    private var classListMutableLiveData: MutableLiveData<List<Classe>> = MutableLiveData()
    private var subjectListMutableLiveData: MutableLiveData<List<String>> = MutableLiveData()

    fun getClassList(): LiveData<List<Classe>> {
        return classListMutableLiveData
    }

    fun getSubjectList(): LiveData<List<String>> {
        return subjectListMutableLiveData
    }

    fun getClasses() {
        classListMutableLiveData.value = getClassesList()
    }

    fun getSubjects() {
        subjectListMutableLiveData.value = getSubjectsList()
    }

}