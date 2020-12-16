package com.vadym.daxxtest.di.modules

import com.vadym.daxxtest.ui.main.MainActivity
import com.vadym.daxxtest.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector
    fun splashActivityInjector(): SplashActivity

    @ContributesAndroidInjector
    fun mainActivityInjector(): MainActivity
}