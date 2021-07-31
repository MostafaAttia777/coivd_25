package com.MostafaCovied.Mostafacovied.network;

import com.MostafaCovied.Mostafacovied.News_model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface News_Listner {


    //https://newsapi.org/
    @GET("v2/everything?domains=wsj.com&apiKey=9bd74a4daa1b427cb60c056309ac85cb")
    Call<NewsResponse> getNews();
}
