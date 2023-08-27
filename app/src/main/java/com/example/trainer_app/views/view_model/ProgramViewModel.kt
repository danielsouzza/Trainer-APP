package com.example.trainer_app.views.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainer_app.data.models.Exercise
import com.example.trainer_app.data.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProgramViewModel: ViewModel() {

    private val apiService = ApiService.providerRetrofit

    //List exercises
    private val _exercisesState = MutableStateFlow(listOf<Exercise>())
    val exerciseState: StateFlow<List<Exercise>> get() = _exercisesState

    // List exercises selected
    private val _exercisesSelected = MutableStateFlow(mutableListOf<Exercise>())
    val exercisesSelected: StateFlow<List<Exercise>> get() = _exercisesSelected

    init {
        getExercises()
    }


    fun addItems(exercises: List<Exercise>){
        _exercisesSelected.value.addAll(exercises)
    }

    fun removeItem(exercise: Exercise){
        _exercisesSelected.value.remove(exercise)
    }
    private fun getExercises(){
        viewModelScope.launch {
            val exercise = apiService.getExercises()
            _exercisesState.value = exercise
        }
    }
}