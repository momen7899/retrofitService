package com.momen.retrofitservice.di

import android.content.Context
import com.momen.data.executor.JobExecutor
import com.momen.data.mapper.DataEntityMapper
import com.momen.data.repository.GetHomeDataRepositoryImpl
import com.momen.data.repository.datasource.HomeDataSourceFactory
import com.momen.domain.executor.PostExecutionThread
import com.momen.domain.executor.ThreadExecutor
import com.momen.domain.interactor.GetDataUseCase
import com.momen.domain.repository.GetHomeDataRepository
import com.momen.retrofitservice.UiThread
import com.momen.retrofitservice.model.DataMapper
import com.momen.retrofitservice.viewmodel.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val context: Context) {

    @Provides
    internal fun provideContext() = context

    @Provides
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread


    @Provides
    internal fun provideHomeViewModelFactory(
        useCase: GetDataUseCase,
        mapper: DataMapper
    ) = HomeViewModelFactory(
        useCase,
        mapper
    )

    @Provides
    internal fun providePageBuilderRepository(
        factory: HomeDataSourceFactory,
        mapper: DataEntityMapper
    ): GetHomeDataRepository = GetHomeDataRepositoryImpl(
        factory,
        mapper
    )

}