package com.myplantdiary.v32001

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myplantdiary.v32001.dto.Plant
import com.myplantdiary.v32001.service.PlantService
import kotlinx.coroutines.launch

class MainViewModel (var plantService : PlantService = PlantService()) : ViewModel() {
    var plants : MutableLiveData<List<Plant>> = MutableLiveData<List<Plant>>()

    fun fetchPlants() {
        viewModelScope.launch{
            var innerPlants = plantService.fetchPlants()
            plants.postValue(innerPlants)
        }
    }
}