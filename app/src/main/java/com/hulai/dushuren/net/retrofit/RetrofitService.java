package com.hulai.dushuren.net.retrofit;


import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by zj on 2017/10/8.
 * 邮箱：zjuan@yonyou.com
 * 描述：(请求参数的配置)-->https://www.jianshu.com/p/7687365aa946、https://www.jianshu.com/p/e0c335c8a3e1
 * https://www.jianshu.com/p/7687365aa946
 */
public interface RetrofitService {
    //    网络接口的使用为查询天气的接口
//    http://wthrcdn.etouch.cn/weather_mini?city=北京
//    若需要重新定义接口地址，可以使用@Url，将地址以参数的形式传入即可。如
//    @GET
//    Call<List<Activity>> getActivityList(
//            @Url String url,
//            @QueryMap Map<String, String> map);
//    Call<List<Activity>> call = service.getActivityList(
//            "http://115.159.198.162:3001/api/ActivitySubjects", map);
//    @Headers({"url_name:other"})
//    @GET("weather_mini")
//    Observable<WeatherEntity> getMessage(@Query("city") String city);
//
//    @GET("selfdesbyid/{teacher_id}")
//    Observable<TeacherDesEntity> getSelfdes(@Path("teacher_id") String teacher_id);
//
//    //post请求
//    @FormUrlEncoded
//    @POST("attentions")
//    Observable<AttentionResponseEntity> doAttention(@Field("topic_id") String topic_id, @Field("type") String type, @Field("user_id") String user_id);
//
//    //post请求方式二
//    //键值对传输的第二种方法
//    @POST("attentions")
//    @Multipart
//    Observable<AttentionResponseEntity> doAttention(@FieldMap Map<String, String> params, @Body List<String> list);
//
//    //传递Object类型参数
//    @POST("attentions")
//    Observable<AttentionResponseEntity> doAttentionOther(@Body WeatherEntity list);
//
//    @POST("attentions")
//    Observable<AttentionResponseEntity> doAttentionOtherLlist(@Body List<WeatherEntity> list);
//
//    //Put请求:https://api-t.zmbai.com/v1/collections/139
//    @FormUrlEncoded  //使用@Field时记得添加@FormUrlEncoded
//    @PUT("collections/{voiceId}")
//    Observable<CancelCollectEntity> cancelCollect(@Path("voiceId") String voiceId, @Field("end_time") String enTime);

//    @POST("upload/")
//    Observable<UserAvatarBean> uploadFile(@Body RequestBody body);
}
