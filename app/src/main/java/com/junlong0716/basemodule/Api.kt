package com.junlong0716.basemodule

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/8/2 下午5:14
 *@modified by:
 */
interface Api {
    @GET("app/api/cfg/query")
    fun requestData(@Query("key") key: String): Observable<ResponseBody>
}
