package com.vadym.daxxtest.ui.splash

import androidx.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {

/*
    var compositeDisposable: CompositeDisposable? = CompositeDisposable()
*/

    val liveData: LiveData<SplashState> get() = mutableLiveData
    private val mutableLiveData = MutableLiveData<SplashState>()


    init {
        GlobalScope.launch {
            delay(5000)
            mutableLiveData.postValue(SplashState.MainActivity)
        }
    }


    // I used coroutine in my example but if we want we can used RxJava or Handler timer
    // in the example below which I commented out, I used RxJava and make the same action

/*    init {
        compositeDisposable?.add(
            Observable.timer(5, TimeUnit.SECONDS)
            .subscribe {
                mutableLiveData.postValue(SplashState.MainActivity)
            })
    }*/

/*
    fun stop(){
        compositeDisposable?.dispose()
    }*/

}
sealed class SplashState {
    object MainActivity : SplashState()
}
