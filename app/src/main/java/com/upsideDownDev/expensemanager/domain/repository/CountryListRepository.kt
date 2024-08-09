package com.upsideDownDev.expensemanager.domain.repository

import com.upsideDownDev.expensemanager.domain.model.CountryDetail

interface CountryListRepository {
    fun getAllCountryList():List<CountryDetail>
}