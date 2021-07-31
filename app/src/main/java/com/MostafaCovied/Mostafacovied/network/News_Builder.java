package com.MostafaCovied.Mostafacovied.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class News_Builder {
    private static Retrofit retrofit;
    //private  static  String BASE_URL="https://newsapi.org/";
    private  static  String BASE_URL="https://newsapi.org/";

    //'summary'
    public static News_Listner getnews(){

        if (retrofit == null){

            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



        }
        return retrofit.create(News_Listner.class);

    }
}