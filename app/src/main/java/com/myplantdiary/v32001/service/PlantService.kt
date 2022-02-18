package com.myplantdiary.v32001.service

import com.myplantdiary.v32001.RetrofitClientInstance
import com.myplantdiary.v32001.dao.IPlantDAO
import com.myplantdiary.v32001.dto.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class PlantService {

    suspend fun fetchPlants(): List<Plant>?{
        return withContext(Dispatchers.IO){
            val service = RetrofitClientInstance.retrofitInstance?.create(IPlantDAO::class.java)
            val plants = async {service?.getAllPlants()}
            var result = plants.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }
}