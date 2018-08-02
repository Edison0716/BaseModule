package com.junlong0716.base.module.http

import android.content.Context
import com.junlong0716.base.module.http.interceptor.CacheInterceptor
import com.junlong0716.base.module.http.interceptor.LogInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/8/2 下午3:46
 *@modified by:
 */
class RetrofitClient private constructor() {
    companion object {
        //单例
        @Volatile
        private var INSTANCE: RetrofitClient? = null
        val instance: RetrofitClient
            get() {
                if (INSTANCE == null) {
                    synchronized(RetrofitClient::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = RetrofitClient()
                        }
                    }
                }
                return INSTANCE!!
            }
    }

    private var mBaseUrl = ""
    private var mRetrofit: Retrofit? = null
    private var mOkHttpClient: OkHttpClient? = null

    //设置请求头
    fun setBaseUrl(baseUrl: String): RetrofitClient {
        this.mBaseUrl = baseUrl
        return this
    }

    //初始化
    fun initClient(mContext: Context) {
        if (mBaseUrl == "") throw IllegalArgumentException("请在Application中初始化请求头！")

        mOkHttpClient = OkHttpClient
                .Builder()
                .cache(Cache(File(mContext.externalCacheDir, "net_request_cache"), (10 * 1024 * 1024).toLong()))
                .addInterceptor(CacheInterceptor())
                .addNetworkInterceptor(CacheInterceptor())
                .addInterceptor(LogInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .build()

        mRetrofit = Retrofit.Builder()
                .client(mOkHttpClient!!)
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun getClient(): Retrofit {
        return mRetrofit!!
    }
}