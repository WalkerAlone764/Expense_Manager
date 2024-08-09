package com.upsideDownDev.expensemanager.di

import com.upsideDownDev.expensemanager.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { MainViewModel(get()) }
}