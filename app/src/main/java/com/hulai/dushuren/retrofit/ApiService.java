package com.hulai.dushuren.retrofit;


import com.hulai.dushuren.retrofit.base.BaseBean;
import com.hulai.dushuren.mvp.model.bean.BookBean;
import com.hulai.dushuren.mvp.model.bean.TeacherBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("Book")
    Observable<BaseBean<BookBean>> getBook(@Query("id") String id);

    @GET("LatestBooks")
    Observable<BaseBean<List<BookBean>>> getBooks(@Query("start") int start, @Query("end") int end);

    @GET("Teacher")
    Observable<BaseBean<TeacherBean>> getTeacher(@Query("id") String id);

    @GET("LatestTeachers")
    Observable<BaseBean<List<TeacherBean>>> getTeachers(@Query("start") int start, @Query("end") int end);

    @GET("Book")
    Call<BaseBean<BookBean>> getBookNoRx(@Query("id") String id);
}
