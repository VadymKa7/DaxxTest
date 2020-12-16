package com.vadym.daxxtest.di.modules

import androidx.lifecycle.ViewModelProvider
import com.vadym.daxxtest.di.impl.ViewModelFactoryImpl
import dagger.Binds
import dagger.Module

@Module
interface ImplModule {
    @Binds fun bindViewModelFactory(factory: ViewModelFactoryImpl): ViewModelProvider.Factory
}
