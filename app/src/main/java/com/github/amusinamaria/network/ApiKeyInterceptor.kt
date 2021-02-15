package com.github.amusinamaria.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter(API_KEY_KEY, API_KEY_VALUE)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }

    private companion object {
        private const val API_KEY_KEY = "api_key"
        private const val API_KEY_VALUE = "38722bc1aa187859abfc5ab2b0717374"
    }
}