package com.momen.retrofitservice.di

import android.content.Context
import com.momen.domain.executor.PostExecutionThread
import com.momen.domain.executor.ThreadExecutor
import com.momen.retrofitservice.view.MainActivity
import dagger.Component


@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun context(): Context

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun inject(homeFragment: MainActivity)
}