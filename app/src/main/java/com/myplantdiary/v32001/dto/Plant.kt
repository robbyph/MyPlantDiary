package com.myplantdiary.v32001.dto

data class Plant (var genus: String, var species : String, var common: String, var cultivar:String ="", var id: Int = 0){
    override fun toString(): String{
        return common
    }
}