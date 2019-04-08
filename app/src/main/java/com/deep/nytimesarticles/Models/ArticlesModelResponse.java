package com.deep.nytimesarticles.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticlesModelResponse {
    @SerializedName("status") public String Status;
   List<Result> articlesModels;

    public ArticlesModelResponse(String status, List<Result> results) {
        Status = status;
        this.articlesModels = results;
    }
}
