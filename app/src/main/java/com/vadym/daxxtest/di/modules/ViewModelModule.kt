package com.vadym.daxxtest.di.modules

import androidx.lifecycle.ViewModel
import com.vadym.daxxtest.ui.child.ChildViewModel
import com.vadym.daxxtest.ui.splash.SplashViewModel
import com.vadym.daxxtest.ui.child.NestedViewModel
import com.vadym.daxxtest.ui.home.DetailsViewModel
import com.vadym.daxxtest.ui.home.EstimateViewModel
import com.vadym.daxxtest.ui.home.HomeViewModel
import com.vadym.daxxtest.ui.main.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NestedViewModel::class)
    abstract fun galleryViewModel(viewModel: NestedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(viewModel: MainViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(ChildViewModel::class)
    abstract fun childViewModel(viewModel: ChildViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun detailsViewModel(viewModel: DetailsViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(EstimateViewModel::class)
    abstract fun estimateViewModel(viewModel: EstimateViewModel): ViewModel

}