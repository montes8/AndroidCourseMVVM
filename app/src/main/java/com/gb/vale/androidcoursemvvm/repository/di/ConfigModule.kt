package com.gb.vale.androidcoursemvvm.repository.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.gb.vale.androidcoursemvvm.BuildConfig
import com.gb.vale.androidcoursemvvm.application.ApplicationCourse
import com.gb.vale.androidcoursemvvm.repository.db.ACMDataBase
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.utils.CONTENT_TYPE
import com.gb.vale.androidcoursemvvm.utils.MY_CONTENT_TYPE
import com.gb.vale.androidcoursemvvm.utils.MY_TIME_ON
import com.gb.vale.androidcoursemvvm.utils.URL_BASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Singleton
    @Provides
    fun providerSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("ACMPreferences", AppCompatActivity.MODE_PRIVATE)

}

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun providerMyDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ACMDataBase::class.java, "acm_course.db").build()

    @Singleton
    @Provides
    fun providerUserDao(db: ACMDataBase) =
        db.userDao()

}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideBaseUrl() = URL_BASE


    @Singleton
    @Provides
    fun provideContext(application: ApplicationCourse): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        )
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(MY_TIME_ON, TimeUnit.SECONDS)
            .writeTimeout(MY_TIME_ON, TimeUnit.SECONDS)
            .readTimeout(MY_TIME_ON, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideACMService(retrofit: Retrofit) : ACMService = retrofit.create(ACMService::class.java)


    @Singleton
    @Provides
    fun providerHeaderInterceptor(): Interceptor {
        return ApiInterceptor()
    }


}

class ApiInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
            .addHeader(MY_CONTENT_TYPE, CONTENT_TYPE)
        request = builder.build()
        return chain.proceed(request)

    }

}




