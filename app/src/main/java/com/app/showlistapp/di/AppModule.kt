package com.app.showlistapp.di

import com.app.showlistapp.data.network.RetrofitFactory
import com.app.showlistapp.data.network.RetrofitProvider
import com.app.showlistapp.data.network.api.IShowListApi
import com.app.showlistapp.data.network.createApi
import com.app.showlistapp.data.network.repositories.ShowListRepository
import com.app.showlistapp.domain.boundaries.IShowListRepository
import com.app.showlistapp.domain.usecase.GetUSPublicUseCase
import com.app.showlistapp.presentation.showlist.ShowListViewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitFactory() }
    single { RetrofitProvider() }
    single<IShowListApi> { createApi(get()) }
    single<IShowListRepository> { ShowListRepository(get()) }
    single { GetUSPublicUseCase(get()) }
    single { ShowListViewModel(get()) }
}