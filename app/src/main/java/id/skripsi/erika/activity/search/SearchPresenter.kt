package id.skripsi.erika.activity.search

import android.content.Context
import android.util.Log
import id.co.pcsindonesia.ia.pos.api.ApiClient
import id.skripsi.erika.model.TanamanResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPresenter(private val homeView: SearchView, private val context: Context?) {

    private val apiInterface = ApiClient().create(context)
    fun getTanaman(query: String?, kategory: String?) {
        homeView.showProgress()
        apiInterface.getTanaman(mapOf("query" to query, "filter" to kategory))
            .enqueue(object : Callback<TanamanResponse> {
                override fun onFailure(call: Call<TanamanResponse>, t: Throwable) {
                    Log.e("Tanaman Error:", t.message.toString())
                    homeView.onFailed(t.message.toString())
                    homeView.hideProgress()
                }

                override fun onResponse(
                    call: Call<TanamanResponse>,
                    response: Response<TanamanResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.code() == 200) {
                            val dataResponse = response.body()
                            when (dataResponse?.code) {
                                200 -> homeView.onSuccess(
                                    dataResponse.data,
                                    dataResponse.key,
                                    dataResponse.total.toString()
                                )
                                400 -> homeView.onFailed(dataResponse.msg)
                            }
                        }
                    } else homeView.onFailed(response.message())
                    homeView.hideProgress()
                }
            })
    }
    fun getAll() {
        homeView.showProgress()
        apiInterface.getAll()
            .enqueue(object : Callback<TanamanResponse> {
                override fun onFailure(call: Call<TanamanResponse>, t: Throwable) {
                    Log.e("Tanaman Error:", t.message.toString())
                    homeView.onFailed(t.message.toString())
                    homeView.hideProgress()
                }

                override fun onResponse(
                    call: Call<TanamanResponse>,
                    response: Response<TanamanResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.code() == 200) {
                            val dataResponse = response.body()
                            when (dataResponse?.code) {
                                200 -> homeView.onSuccess(
                                    dataResponse.data,
                                    dataResponse.key,
                                    dataResponse.total.toString()
                                )
                                400 -> homeView.onFailed(dataResponse.msg)
                            }
                        }
                    } else homeView.onFailed(response.message())
                    homeView.hideProgress()
                }
            })
    }
}