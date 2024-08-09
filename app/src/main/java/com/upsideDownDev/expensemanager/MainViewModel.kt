package com.upsideDownDev.expensemanager

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upsideDownDev.expensemanager.domain.usecase.GetCountryListUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val countryListUseCase: GetCountryListUseCase
): ViewModel() {

    init {
        viewModelScope.launch {
            countryListUseCase("").collectLatest {
                Log.d("country viemodel: ",it.toString())
            }
        }
    }
}