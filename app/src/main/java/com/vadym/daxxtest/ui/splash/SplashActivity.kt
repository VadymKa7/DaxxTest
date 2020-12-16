package com.vadym.daxxtest.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vadym.daxxtest.di.impl.injectViewModel
import com.vadym.daxxtest.ui.main.MainActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        viewModel = injectViewModel(viewModelFactory)

        viewModel.liveData.observe(this, {
            when (it) {
                is SplashState.MainActivity -> {
                    goToMainActivity()
                }
            }
        })
    }


/*    override fun onStop() {
        super.onStop()
            viewModel.stop()
    }*/

    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}
