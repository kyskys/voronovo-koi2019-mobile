package by.schools.voronovo.koiapp.data

import by.schools.voronovo.koiapp.data.api.CategoriesRepository
import by.schools.voronovo.koiapp.data.impl.CategoriesRepositoryImpl
import by.schools.voronovo.koiapp.data.remote.api.Api
import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {
    single<Moshi> { Moshi.Builder().build() }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("http://172.31.1.14:8080")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Api> { get<Retrofit>().create(Api::class.java) }
    single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }
}