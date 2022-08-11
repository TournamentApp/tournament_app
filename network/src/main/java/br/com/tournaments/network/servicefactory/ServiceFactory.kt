package br.com.tournaments.network.servicefactory

interface ServiceFactory {
    fun <T> create(service: Class<T>): T
}