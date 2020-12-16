package com.vadym.daxxtest.di.modules

import com.vadym.daxxtest.ui.child.ChildFragment
import com.vadym.daxxtest.ui.child.NestedFragment
import com.vadym.daxxtest.ui.home.DetailsFragment
import com.vadym.daxxtest.ui.home.EstimateFragment
import com.vadym.daxxtest.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector
    fun homeFragmentInjector(): HomeFragment

    @ContributesAndroidInjector
    fun galleryFragmentInjector(): NestedFragment

    @ContributesAndroidInjector
    fun childFragmentInjector(): ChildFragment

    @ContributesAndroidInjector
    fun detailsFragmentInjector(): DetailsFragment

    @ContributesAndroidInjector
    fun estimateFragmentInjector(): EstimateFragment

}