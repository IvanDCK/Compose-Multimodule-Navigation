package com.dck.core.di

import com.dck.module_b.model.Mobile
import com.dck.module_b.presentation.ScreenBViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    single<Mobile> { Mobile("Samsung", 1000.0, "Black", 6.5) }
    viewModel { ScreenBViewModel(get()) }
}