package com.vadym.daxxtest.di

import android.content.Context
import com.vadym.daxxtest.AndroidApplication
import com.vadym.daxxtest.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivitiesModule::class,
    FragmentsModule::class,
    ViewModelModule::class,
    ImplModule::class
])

interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidApplication)
}
