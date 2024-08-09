package com.upsideDownDev.expensemanager.di

import com.upsideDownDev.expensemanager.data.repository.CountryListRepositoryImpl
import com.upsideDownDev.expensemanager.domain.repository.CountryListRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::CountryListRepositoryImpl) { bind<CountryListRepository>() }
}