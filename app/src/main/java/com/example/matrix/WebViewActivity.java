package com.example.matrix;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {


    private WebView wvmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_web_view );

        wvmain = findViewById( R.id.wv );
        //wvmain.loadUrl( "file://android_asset/four.html" );

        wvmain.setWebViewClient( new mywebviewClient() );
        wvmain.getSettings().setJavaScriptEnabled( true );
        wvmain.setWebChromeClient( new mywebchroneclient() );
        wvmain.loadUrl( "http://m.baidu.com" );

    }

    class mywebviewClient extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl( request.getUrl().toString() );
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted( view, url, favicon );
            Log.d( "webview", "onPageStarted..." );
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished( view, url );
            Log.d( "webview", "onPageFinished..." );
        }
    }

    class mywebchroneclient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged( view, newProgress );
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle( view, title );
            setTitle( title );
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && wvmain.canGoBack()) {
            wvmain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
