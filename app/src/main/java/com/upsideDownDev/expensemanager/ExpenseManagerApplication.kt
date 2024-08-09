package com.upsideDownDev.expensemanager

import android.app.Application
import com.upsideDownDev.expensemanager.di.repositoryModule
import com.upsideDownDev.expensemanager.di.useCaseModule
import com.upsideDownDev.expensemanager.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ExpenseManagerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ExpenseManagerApplication)
            modules(listOf(repositoryModule, useCaseModule, viewmodelModule))
        }

    }
}