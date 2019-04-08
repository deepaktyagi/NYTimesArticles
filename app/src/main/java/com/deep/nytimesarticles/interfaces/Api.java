package com.deep.nytimesarticles.interfaces;

import com.deep.nytimesarticles.Models.ArticlesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {


    //@GET("viewed/7.json?api-key=oSaiTuFwiAr0os3I7hXJo4DQYirK7eYz")
    @GET("viewed/7.json")
    Call<ArticlesModel> getArticles(@Query("api-key") String api_key);
}
