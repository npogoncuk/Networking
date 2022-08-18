package com.example.networking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networking.network.ResultsApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ResultsApiStatus { LOADING, ERROR, DONE }

class MyViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _status = MutableLiveData<ResultsApiStatus>()
    val status: LiveData<ResultsApiStatus> = _status

    init {
        getResults()
    }

    private fun getResults() {
        viewModelScope.launch {
            _status.value = ResultsApiStatus.LOADING
            try {
                _result.value = ResultsApi.retrofitService.getJson()
                _status.value = ResultsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ResultsApiStatus.ERROR
                _result.value = ""
            }
        }
    }
}
