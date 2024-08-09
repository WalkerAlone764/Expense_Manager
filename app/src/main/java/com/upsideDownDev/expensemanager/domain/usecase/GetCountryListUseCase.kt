package com.upsideDownDev.expensemanager.domain.usecase

import com.upsideDownDev.expensemanager.domain.model.CountryDetail
import com.upsideDownDev.expensemanager.domain.repository.CountryListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCountryListUseCase(
    private val countryListRepository: CountryListRepository
) {
    operator fun invoke(search: String): Flow<List<CountryDetail>> {
        return flow {
            emit(countryListRepository.getAllCountryList().filter {
                it.countryName.contains(search)
            })
        }
    }
}