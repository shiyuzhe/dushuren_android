package com.hulai.dushuren.retrofit;


import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/12.
 * Retrofit2+ OkHttp3+RxJava2
 */

public class RetrofitFactory {
    private static RetrofitFactory mRetrofitFactory;
    private static Retrofit retrofit;

    public static RetrofitFactory getInstance() {
        RetrofitFactory inst = mRetrofitFactory;
        if (inst == null) {
            synchronized (RetrofitFactory.class) {
                inst = mRetrofitFactory;
                if (inst == null) {
                    inst = new RetrofitFactory();
                    mRetrofitFactory = inst;
                }
            }
        }
        return inst;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofit == null) {
                    InterceptorUtil interceptorUtil = new InterceptorUtil();
                    OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(SessionCenter.HTTP_TIME, TimeUnit.SECONDS)
                            .readTimeout(SessionCenter.HTTP_TIME, TimeUnit.SECONDS)
                            .writeTimeout(SessionCenter.HTTP_TIME, TimeUnit.SECONDS)
                            .addInterceptor(interceptorUtil.HeaderInterceptor())
                            .addInterceptor(interceptorUtil.LogInterceptor())//添加日志拦截器
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl(SessionCenter.urlRoot)
                            .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                            .client(mOkHttpClient)
                            .build();
                }
            }
        }
        return retrofit;
    }

    class InterceptorUtil {
        public String TAG = "----";

        //日志拦截器
        public HttpLoggingInterceptor LogInterceptor() {
            return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    if (message.contains(SessionCenter.urlRoot) || message.contains("success"))
                        Log.e("syz_requestUrl", "log: " + message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
        }

        public Interceptor HeaderInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request mRequest = chain.request();
                    //在这里你可以做一些想做的事,比如token失效时,重新获取token
                    //或者添加header等等,PS我会在下一篇文章总写拦截token方法
                    return chain.proceed(mRequest);
                }
            };

        }
    }
}
