package com.webbrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Windows10 on 17.07.2017.
 */

class benimClas extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url)
    {
        v.loadUrl(url);
        return true;
    }


}
