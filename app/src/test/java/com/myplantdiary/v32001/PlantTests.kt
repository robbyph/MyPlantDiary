package com.myplantdiary.v32001

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.myplantdiary.v32001.dto.Plant
import com.myplantdiary.v32001.service.PlantService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class PlantTests {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var plantService: PlantService
    var allPlants: List<Plant>? = ArrayList<Plant>()

    @Test
    fun `Given plant data are available when i search for redbud then i should recieve cercis canadensis`() = runTest {
        givenPlantServiceIsInitalized()
        whenPlantDataAreReadAndParsed()
        thenThePlantCollectionShouldContainCercisCanadensis()
    }

    private fun givenPlantServiceIsInitalized() {
        plantService = PlantService()
    }

    private suspend fun whenPlantDataAreReadAndParsed() {
        allPlants = plantService.fetchPlants()

    }

    private fun thenThePlantCollectionShouldContainCercisCanadensis() {
        assertNotNull(allPlants)
        assertTrue(allPlants!!.isNotEmpty())
        var containsCercisCanadensis = false
        allPlants!!.forEach {
            if (it.genus.equals(("Cercis")) && it.species.equals("canadensis")){
                containsCercisCanadensis = true
            }
        }
        assertTrue(containsCercisCanadensis)
    }


}