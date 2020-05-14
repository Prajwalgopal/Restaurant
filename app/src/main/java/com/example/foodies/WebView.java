package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class WebView extends AppCompatActivity {  // WEBVIEW OF THE APPLICATION
    private android.webkit.WebView webView;
    private Customlist data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (android.webkit.WebView)findViewById(R.id.web);

        Intent intent =getIntent();
        Bundle bundle= intent.getExtras();

        data=(Customlist)bundle.getSerializable("data");
        String url= data.getUrl();
webView.getSettings().setJavaScriptEnabled(true);
webView.loadUrl(url);
    }
}
