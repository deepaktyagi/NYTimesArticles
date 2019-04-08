package com.deep.nytimesarticles.interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //public static String baseUrl = "http://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=oSaiTuFwiAr0os3I7hXJo4DQYirK7eYz";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(String baseUrl){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    ).build();
        }
        return retrofit;
    }
}
