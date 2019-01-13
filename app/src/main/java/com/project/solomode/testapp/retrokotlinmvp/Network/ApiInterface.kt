package com.project.solomode.testapp.retrokotlinmvp.Network

import com.project.solomode.testapp.retrokotlinmvp.Model.Instansi
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("data/getData.php")
    fun getAllData(@Query("lat") lat : String, @Query("lng") lng : String): Observable<List<Instansi>>

}