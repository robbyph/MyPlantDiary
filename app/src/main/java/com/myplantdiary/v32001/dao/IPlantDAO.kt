package com.myplantdiary.v32001.dao

import com.myplantdiary.v32001.dto.Plant
import retrofit2.Call
import retrofit2.http.GET

interface IPlantDAO {

    @GET("/perl/mobile/viewplantsjsonarray.pl")
    fun getAllPlants(): Call<ArrayList<Plant>>
}