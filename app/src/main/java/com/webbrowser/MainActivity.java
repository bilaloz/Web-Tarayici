package com.webbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ileri,geri,yenile,gecmis,git;
    WebView browser;
    EditText webAdresi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView) findViewById(R.id.wvBrowser);
        ileri = (Button)findViewById(R.id.btIleri);
        geri = (Button)findViewById(R.id.btGeri);
        git = (Button)findViewById(R.id.btGit);
        gecmis = (Button)findViewById(R.id.btGecmis);
        yenile = (Button)findViewById(R.id.btYenile);
        webAdresi = (EditText)findViewById(R.id.etAdres);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);

        browser.setWebViewClient(new benimClas());
        browser.loadUrl("https://www.google.com");

        ileri.setOnClickListener(this);
        gecmis.setOnClickListener(this);
        yenile.setOnClickListener(this);
        geri.setOnClickListener(this);
        git.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btGecmis:
                browser.clearHistory();
                break;
            case R.id.btGit:
                String gidilecek = webAdresi.getText().toString();
                browser.loadUrl(gidilecek);

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(webAdresi.getWindowToken(),0);

                break;
            case R.id.btIleri:
                browser.goForward();
                break;
            case R.id.btGeri:
                if(browser.canGoBack()){
                    browser.goBack();
                }
                break;
            case R.id.btYenile:
                browser.reload();
                break;

        }

    }
}
