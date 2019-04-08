package com.deep.nytimesarticles.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.deep.nytimesarticles.Models.ArticlesModel;
import com.deep.nytimesarticles.Models.Result;
import com.deep.nytimesarticles.interfaces.Api;
import com.deep.nytimesarticles.interfaces.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArticleViewModel extends ViewModel {

    private MutableLiveData<List<Result>> articleList;

    public LiveData<List<Result>> getArticles(String apiUrl){
        if (articleList == null){
            articleList = new MutableLiveData<List<Result>>();
            LoadArticles(apiUrl);
        }
        return articleList;
    }

    private void LoadArticles(String apiUrl){
        Retrofit retrofit = ApiClient.getApiClient(apiUrl);

        Api api = retrofit.create(Api.class);
        Call<ArticlesModel> call = null;
        try {
           call = api.getArticles("oSaiTuFwiAr0os3I7hXJo4DQYirK7eYz");
        }catch(Exception e)
        {
            Log.d("dt185028",e.toString());
        }
        String hiturl = call.request().url().toString();


        call.enqueue(new Callback<ArticlesModel>() {
            @Override
            public void onResponse(Call<ArticlesModel> call, Response<ArticlesModel> response) {
                //finally we are setting the list to our MutableLiveData
                if (response.isSuccessful()) {

                    articleList.setValue(response.body().getResults());
                    Log.d("dt185028", response.toString());
                    Log.d("dt185028", response.body().toString());
                }
                else
                    Log.d("dt185028", response.errorBody().toString());

                //articleList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArticlesModel> call, Throwable t) {
                Log.d("dt185028", t.toString());
            }


        });




    }
}
