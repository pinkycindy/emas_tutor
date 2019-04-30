package com.pinkycindy.emas_tutor.data.source.remote;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Pinky Cindy on 12/26/18.
 */

public interface ApiInterface {

//    @GET("class")
//    Call<ClassroomResponse> getJSON();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(
            @Field("email") String email,
            @Field("password") String pass
    );

//    @FormUrlEncoded
//    @POST("getClass")
//    Call<ClassroomResponse> myclass(
//            @Field("id") String id);
//
//    @GET("ClassKosong")
//    Call<ClassroomResponse> dataClass();
//
//    @FormUrlEncoded
//    @POST("pilihclass")
//    Call<ClassroomResponse> pilih(
//            @Field("class_id") String id,
//            @Field("emp_id") String emp);

}
