package com.upsideDownDev.expensemanager.di

import com.upsideDownDev.expensemanager.domain.usecase.GetCountryListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCountryListUseCase(get()) }
}