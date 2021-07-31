package com.MostafaCovied.Mostafacovied.News_Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.News_model.Article;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class News_Adpter extends RecyclerView.Adapter<News_Adpter.News_vh_holder> {

    OnclickListner listner;
    ArrayList<Article> newsResponses;

    public News_Adpter( ArrayList<Article> newsResponses,OnclickListner listner) {

        this.newsResponses = newsResponses;
        this.listner = listner;
    }




    @NonNull
    @Override
    public News_vh_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_news_layout, parent, false);

        return new News_vh_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull News_vh_holder holder, int position) {
        holder.textView_data.setText(newsResponses.get(position).getPublishedAt());
        holder.textView_title.setText(newsResponses.get(position).getTitle());
        Picasso.get().load(newsResponses.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsResponses.size();
    }

    class News_vh_holder extends RecyclerView.ViewHolder {

        TextView textView_title;
        TextView textView_data;
        ImageView imageView;

        public News_vh_holder(@NonNull View itemView) {
            super(itemView);
            textView_data = itemView.findViewById(R.id.news_data);
            textView_title = itemView.findViewById(R.id.news_title);
            imageView = itemView.findViewById(R.id.news_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
