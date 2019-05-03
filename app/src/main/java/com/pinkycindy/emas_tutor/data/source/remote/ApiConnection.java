package com.pinkycindy.emas_tutor.data.source.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pinky Cindy
 */
public class ApiConnection {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.43.191/emas/public/api/";

    public static ApiInterface getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;

    }
}
