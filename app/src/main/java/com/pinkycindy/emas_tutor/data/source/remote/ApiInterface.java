package com.pinkycindy.emas_tutor.data.source.remote;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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

    @FormUrlEncoded
    @POST("absen")
    Call<ResponseBody> addAttendaces(
            @Field("emp_id") String emp_id,
            @Field("spot_id") Integer spot_id,
            @Field("class_id") Integer id,
            @Field("checkin_lat") Double lat,
            @Field("checkin_lng") Double lng
    );

    @FormUrlEncoded
    @POST("updateAttendances")
    Call<ResponseBody> updateAttendaces(
            @Field("id") Integer id,
            @Field("checkout_lat") Double lat,
            @Field("checkout_lng") Double lng
    );

    @FormUrlEncoded
    @POST("getScheduleinDay")
    Call<ResponseBody> getScheduleinDay(
        @Field("emp_id") String emp_id,
        @Field("day") Integer day
    );

    @GET("getClassKosong")
    Call<ResponseBody> getClassEmpty();

    @FormUrlEncoded
    @POST("pilihclass")
    Call<ResponseBody> chooseClassroom(
            @Field("class_id") String id,
            @Field("emp_id") String emp
    );


    @FormUrlEncoded
    @POST("cekHistoryAttendances")
    Call<ResponseBody> cekHistoryAttendances(
            @Field("emp_id") String emp_id,
            @Field("tgl") String tgl
    );


    @FormUrlEncoded
    @POST("getProfilTutor")
    Call<ResponseBody> getProfil(
            @Field("emp_id") String emp_id
    );

    @FormUrlEncoded
    @POST("getReport")
    Call<ResponseBody> getReport(
            @Field("emp_id") String emp_id,
            @Field("thn") String tahun
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
