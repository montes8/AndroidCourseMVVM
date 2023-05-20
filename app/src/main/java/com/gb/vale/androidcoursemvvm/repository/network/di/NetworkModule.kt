package com.gb.vale.androidcoursemvvm.repository.network.di

import android.content.Context
import com.gb.vale.androidcoursemvvm.BuildConfig
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.repository.network.api.DataNetwork
import com.gb.vale.androidcoursemvvm.usecases.network.IDataNetwork
import com.gb.vale.androidcoursemvvm.utils.CONTENT_TYPE
import com.gb.vale.androidcoursemvvm.utils.MY_TIME_ON
import com.gb.vale.androidcoursemvvm.utils.URL_BASE_NAME
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { providerHttpLoggingInterceptor() }
    single { providerCache(get()) }
    single { ApiInterceptor() }
    single { providerOkHttpClient(get(), get()) }
    single { providerRetrofit(getProperty(URL_BASE_NAME), get()) }
    single { providerApi(get()) }
    single <IDataNetwork>{ DataNetwork(get()) }

}

fun providerApi(retrofit: Retrofit): ACMService {
    return retrofit.create(ACMService::class.java)
}

fun providerRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun providerOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    apiInterceptor: ApiInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(MY_TIME_ON, TimeUnit.SECONDS)
        .writeTimeout(MY_TIME_ON, TimeUnit.SECONDS)
        .readTimeout(MY_TIME_ON, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(apiInterceptor)
        .build()
}

fun providerCache(context: Context): Cache {
    val cacheSize: Long = 10485760
    return Cache(context.cacheDir, cacheSize)
}

fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return logging
}

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
            .addHeader("Content-Type", CONTENT_TYPE)

        request = builder.build()
        return chain.proceed(request)
    }
}




