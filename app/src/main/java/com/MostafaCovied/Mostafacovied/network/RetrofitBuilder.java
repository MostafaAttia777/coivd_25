package com.MostafaCovied.Mostafacovied.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

private static Retrofit retrofit;
//private  static  String BASE_URL="https://newsapi.org/";
private  static  String BASE_URL="https://api.covid19api.com/";

//'summary'
  public static Covid_Counter getserves(){

if (retrofit == null){

    retrofit=new Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



}
return retrofit.create(Covid_Counter.class)  ;

}
}
