package com.example.dalyakhatun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView web = (WebView) findViewById(R.id.webView);
        String google = "http://www.google.com";
        Intent in = getIntent();
        final String input = in.getExtras().getString("url");


        final ArrayList BlockedWebsiteList = in.getStringArrayListExtra("list");

        web.loadUrl("http://www.google.com");
        web.setWebViewClient(new WebViewClient());




        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Here put your code

                if(url.contains(input)){
                    errorm();
                    return true;

                }
                else{
                return false; //Indicates WebView to NOT load the url;
                //return false; //Allow WebView to load url
            }
            }
        });
    }

    private void errorm() {
        Intent i = new Intent(this, error.class);
        startActivity(i);
    }
}


