package com.example.michael.nbaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.support.v7.widget.Toolbar;

public class WebViewActivity extends AppCompatActivity {
    public static String EXTRA_TITLE = "title";
    public static String EXTRA_URL = "https://www.google.com";

    private WebView mWebView;
    private ProgressBar mProgressLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = getIntent().getStringExtra(EXTRA_URL);
        String title = getIntent().getStringExtra(EXTRA_TITLE);


        mWebView = (WebView) findViewById(R.id.wv_browser);
        mProgressLoading = (ProgressBar) findViewById(R.id.pb_loading);

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
                if(mProgressLoading != null) {
                    if(newProgress < 100 && mProgressLoading.getVisibility() == ProgressBar.GONE) {
                        mProgressLoading.setVisibility(ProgressBar.VISIBLE);
                    }

                    mProgressLoading.setProgress(newProgress);

                    if(newProgress == 100) mProgressLoading.setVisibility(View.GONE);
                }
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.loadUrl(url);

    }
}
