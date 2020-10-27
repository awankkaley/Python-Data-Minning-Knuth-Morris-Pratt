package id.skripsi.erika.api

import id.skripsi.erika.model.TanamanResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    //----- GET ALL DATA ------
    @Headers(
        "Content-Type: application/json"
    )
    @POST("/api/kmp")
    fun getTanaman(
        @Body body: Map<String,String?>
    ): Call<TanamanResponse>
    //----- GET ALL DATA ------
    @Headers(
        "Content-Type: application/json"
    )
    @POST("/api/all")
    fun getAll(
    ): Call<TanamanResponse>
}