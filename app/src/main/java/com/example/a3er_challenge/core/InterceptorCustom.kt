package com.example.a3er_challenge.core

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorCustom : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Api-Key", Config.apiKey)
            .build()
        return chain.proceed(request)
    }
}
