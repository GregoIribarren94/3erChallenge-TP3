package com.example.a3er_challenge.di

import android.R.attr.level

import com.example.a3er_challenge.Model.QuoteApi
import com.example.a3er_challenge.core.Config
import com.example.a3er_challenge.core.InterceptorCustom
import com.example.a3er_challenge.shared.IServiceQuotes
import com.example.a3er_challenge.shared.QuoteRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(InterceptorCustom())
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Config.baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideQuoteApi(retrofit: Retrofit): QuoteApi =
        retrofit.create(QuoteApi::class.java)

    @Provides
    @Singleton
    fun provideIServiceQuotes(quoteRetrofit: QuoteRetrofit): IServiceQuotes = quoteRetrofit
}