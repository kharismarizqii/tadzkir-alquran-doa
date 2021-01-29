package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network.ApiResponse
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network.ApiService
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllTahlil(): LiveData<ApiResponse<List<TahlilResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TahlilResponse>>>()

        val client = apiService.getListTahlil()

        client.enqueue(object : Callback<ListTahlilResponse> {
            override fun onResponse(
                call: Call<ListTahlilResponse>,
                response: Response<ListTahlilResponse>
            ) {
                val dataArray = response.body()?.list
                resultData.value =
                    if (dataArray != null) {
                        ApiResponse.Success(dataArray)
                    } else {
                        ApiResponse.Empty
                    }
            }

            override fun onFailure(call: Call<ListTahlilResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })
        return resultData
    }

    fun getAllAsmaul(): LiveData<ApiResponse<List<AsmaulResponse>>>{
        val resultData = MutableLiveData<ApiResponse<List<AsmaulResponse>>>()

        val client = apiService.getListAsmaul()

        client.enqueue(object : Callback<ListAsmaulResponse>{
            override fun onResponse(
                call: Call<ListAsmaulResponse>,
                response: Response<ListAsmaulResponse>
            ) {
                val dataArray = response.body()?.list
                resultData.value = if (dataArray!=null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListAsmaulResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }

        })
        return resultData
    }

    fun getAllDoaHarian(): LiveData<ApiResponse<List<DoaHarianResponse>>>{
        val resultData = MutableLiveData<ApiResponse<List<DoaHarianResponse>>>()

        val client = apiService.getListDoaHarian()

        client.enqueue(object : Callback<ListDoaHarianResponse>{
            override fun onResponse(
                call: Call<ListDoaHarianResponse>,
                response: Response<ListDoaHarianResponse>
            ) {
                val dataArray = response.body()?.list
                resultData.value = if (dataArray!=null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListDoaHarianResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }

        })
        return resultData
    }

    fun getAllBacaanShalat(): LiveData<ApiResponse<List<BacaanShalatResponse>>>{
        val resultData = MutableLiveData<ApiResponse<List<BacaanShalatResponse>>>()

        val client = apiService.getListBacaanShalat()

        client.enqueue(object : Callback<List<BacaanShalatResponse>>{
            override fun onResponse(
                call: Call<List<BacaanShalatResponse>>,
                response: Response<List<BacaanShalatResponse>>
            ) {
                val dataArray = response.body()
                resultData.value = if (dataArray!=null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<List<BacaanShalatResponse>>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }

        })
        return resultData
    }

    fun getAyat(): LiveData<AlquranRawResponse>{
        val resultData = MutableLiveData<AlquranRawResponse>()

        val client =  apiService.getAyat()

        client.enqueue(object : Callback<AlquranRawResponse>{
            override fun onResponse(
                call: Call<AlquranRawResponse>,
                response: Response<AlquranRawResponse>
            ) {
                val data = response.body()
                resultData.value = data
            }

            override fun onFailure(call: Call<AlquranRawResponse>, t: Throwable) {
                Log.e("RemoteDataSource", t.message.toString())
            }
        })
        return resultData
    }
}