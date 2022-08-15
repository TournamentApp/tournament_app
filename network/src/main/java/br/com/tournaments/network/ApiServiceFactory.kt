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
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClientFactory.create())
        .build()

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

}