package com.example.dalyakhatun.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView web = (WebView) findViewById(R.id.webView);
        String url = "http://www.google.com";
        web.loadUrl(url);

//        Bundle extras = getIntent().getExtras();
//
//        String blockurl = extras.getString("url");
//        web.loadUrl(blockurl);
//
//        web.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if(url.contains("facebook.com")) {
//                    view.loadUrl(url);
//                }
//                return true;
//            }
//        });

        }


    }


