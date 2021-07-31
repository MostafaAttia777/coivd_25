package com.MostafaCovied.Mostafacovied.News_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.MostafaCovied.Mostafacovied.R;

public class Open_news extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_news);
        webView = findViewById(R.id.tv_web_view);

        Intent intent = getIntent();

        //String url = intent.getStringExtra("link");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(intent.getStringExtra("link"));

    }
}
