package com.shah.tfltubelines.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.tfltubelines.model.TubeLineStatus
import com.shah.tfltubelines.repository.Repository
import com.shah.tfltubelines.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    private val _tubeLineStatuses : MutableLiveData<UiState> = MutableLiveData(UiState.Loading)
    val tubeLineStatuses: LiveData<UiState> get() = _tubeLineStatuses

    init {
        getTubeLinesStatuses()
    }

    fun getTubeLinesStatuses() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getTubeLinesStatuses()
                if (response.isSuccessful) {
                    _tubeLineStatuses.postValue(
                        response.body()?.let {
                            UiState.Success(
                                response.body() as TubeLineStatus
                            )
                        }
                    )
                } else {
                    _tubeLineStatuses.postValue(
                        UiState.Error(
                            Throwable(
                                response.message()
                            )
                        )
                    )
                }
            } catch (e: Exception) {
            }
        }
    }
}