package com.MostafaCovied.Mostafacovied.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.News_Activity.News_Adpter;
import com.MostafaCovied.Mostafacovied.News_Activity.Open_news;
import com.MostafaCovied.Mostafacovied.News_model.Article;
import com.MostafaCovied.Mostafacovied.News_model.NewsResponse;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;
import com.MostafaCovied.Mostafacovied.network.News_Builder;
import com.MostafaCovied.Mostafacovied.network.News_Listner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Newspaper extends Fragment {

    News_Listner news_listner;
    ArrayList<Article> articleArrayList = new ArrayList<>();
    List<Article> articleList = new ArrayList<>();
    RecyclerView recyclerView;
    News_Adpter news_adpter;

    public Newspaper() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_newspaper, container, false);
        recyclerView = view.findViewById(R.id.rc_news);
        news_listner = News_Builder.getnews();
        news_listner.getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (Article article : response.body().getArticles()) {
//                        String t = article.getTitle();
//                        Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT).show();
                        String article_title = article.getTitle();
                        String article_data = article.getPublishedAt();
                        String article_image = article.getUrlToImage();
                        String article_link = article.getUrl();
                        //  articleArrayList.add(new Article(article_title,article_link,article_image,article_data));
                        articleList.add(new Article(article_title, article_link, article_image, article_data));
                        news_adpter = new News_Adpter((ArrayList<Article>) articleList, new OnclickListner() {
                            @Override
                            public void onItemClick(int position) {
                                Intent open_news = new Intent(getActivity(), Open_news.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("link", articleList.get(position).getUrl());
                                open_news.putExtras(bundle);
                                view.getContext().startActivity(open_news);

                            }
                        });
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setAdapter(news_adpter);
                    }

                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
        return view;
    }
}
