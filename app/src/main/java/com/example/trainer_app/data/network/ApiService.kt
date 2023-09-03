package com.example.trainer_app.data.network

import com.example.trainer_app.data.models.Credentials
import com.example.trainer_app.data.models.Exercise
import com.example.trainer_app.data.models.Token
import com.example.trainer_app.data.models.TrainingProgram
import com.example.trainer_app.data.models.User
import com.example.trainer_app.data.models.UserAble
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    companion object{
        private const val BASE_URL = "http://192.168.12.227 /api/" //146.190.163.166
        var providerRetrofit: ApiService = createProviderRetrofit("")

        private fun createProviderRetrofit(token: String):ApiService {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            OAuthInterceptor(tokenType = "Bearer", accessToken=token)
                        )
                        .addInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }
                        )
                        .build()
                )
                .build().create(ApiService::class.java)
        }

        fun setTokenProvider(token: Token){
            val providerRetrofitWithToken = createProviderRetrofit(token.accessToken)
            providerRetrofit = providerRetrofitWithToken
        }
    }

    @POST("auth")
    suspend fun auth(@Body credentials: Credentials): Token

    @GET("program/{id}")
    suspend fun getProgram(@Path("id")id:Int): TrainingProgram

    @POST("program/{id}")
    suspend fun createProgram(@Body trainingProgram: TrainingProgram):ResponseBody

    @GET("users/me")
    suspend fun me(): User

    @POST("users")
    suspend fun createUser(@Body user: UserAble): ResponseBody

    @GET("exercise")
    suspend fun getExercises(): List<Exercise>

    @GET("trainer/students")
    suspend fun getMyStudents(): List<User>
}