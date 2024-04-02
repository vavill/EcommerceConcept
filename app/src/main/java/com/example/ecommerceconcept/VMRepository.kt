package com.example.ecommerceconcept

import javax.inject.Inject

class VMRepository @Inject constructor(
     private val dataSource: VMLocalDataSource,
) {

    fun getNextValue(): Int {
        return dataSource.getNextValue()
    }
}