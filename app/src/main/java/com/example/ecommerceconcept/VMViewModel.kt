package com.example.ecommerceconcept

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class VMViewModel @Inject constructor(
    //private val repository: VMRepository,
) : ViewModel() {

    private val _counterLiveData: MutableLiveData<Int> = MutableLiveData()
    val counterLiveData: LiveData<Int> = _counterLiveData

    fun onButtonClick() {
      //  _counterLiveData.postValue(repository.getNextValue())
    }
}