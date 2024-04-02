package com.example.ecommerceconcept

import javax.inject.Inject

class VMLocalDataSource @Inject constructor() {

    private var counter = 0

     fun getNextValue(): Int {
       return ++counter
    }
}