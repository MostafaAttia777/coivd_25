package com.MostafaCovied.Mostafacovied.network;

import com.MostafaCovied.Mostafacovied.model.Counter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid_Counter {


    // @GET("v2/top-headlines?country=eg&category=sports&apiKey=c4652d58322344a783a6cea9e37e0707")
     @GET("summary")
     Call<Counter> getSportNews();


}
