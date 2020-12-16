package com.vadym.daxxtest

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.vadym.daxxtest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AndroidApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        //I Add Dagger 2 to application. Like ac an alternative we may use Koin or Kodein for realizing di.
        DaggerAppComponent.builder().context(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentInjector

}