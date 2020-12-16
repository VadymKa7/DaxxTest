package com.vadym.daxxtest.di.modules


import com.vadym.daxxtest.api.AppService
import com.vadym.daxxtest.api.AuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideNewsService(@NewsAPI okhttpClient: OkHttpClient,
                           converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, AppService::class.java)


    @NewsAPI
    @Provides
    fun providePrivateOkHttpClient(
        upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder()
            .addInterceptor(AuthInterceptor("<your_api_token>")).build()
    }

    private fun createRetrofit(
            okHttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl(AppService.ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .build()
    }

    private fun <T> provideService(okHttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory, clazz: Class<T>): T {
        return createRetrofit(okHttpClient, converterFactory).create(clazz)
    }



}
