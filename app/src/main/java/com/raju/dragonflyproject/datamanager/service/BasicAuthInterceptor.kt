package com.raju.dragonflyproject.datamanager.service

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BasicAuthInterceptor(user: String, password: String) : Interceptor {

    private val AUTHORIZATION: String = "Authorization"
    private val credentials: String

    init {
        this.credentials = Credentials.basic(user, password)
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
                .header(AUTHORIZATION, credentials).build()
        return chain.proceed(authenticatedRequest)
    }

}