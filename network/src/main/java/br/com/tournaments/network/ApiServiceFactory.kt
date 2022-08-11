package br.com.tournaments.network

import br.com.tournaments.network.httpclient.OkHttpClientFactory
import br.com.tournaments.network.servicefactory.ServiceFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServiceFactory (
    okHttpClientFactory: OkHttpClientFactory
) : ServiceFactory {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("http://127.0.0.1:8000/api/")
        .client(okHttpClientFactory.create())
        .build()

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

}