package com.a1ubkh4n.nusyllabus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class legal_aspects_busin extends AppCompatActivity {

    WebView webA;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_aspects_busin);

        webA = (WebView) findViewById(R.id.weblegalAspect);
        bar=(ProgressBar) findViewById(R.id.progresslegalAspect);
        webA.setWebViewClient(new myWebclient());
        //WebSettings webSettings = webView.getSettings();
        //webSettings.getJavaScriptEnabled(true);
        webA.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webA.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webA.getSettings().setAppCacheEnabled(true);

        String myurl = "file:///android_asset/www/legal_aspects_busin.html";
        webA.getSettings().setJavaScriptEnabled(true);
        webA.loadUrl(myurl);

        Toolbar toolbar = (Toolbar) findViewById( R.id.legalAspect );
        setSupportActionBar( toolbar );

        AdView adView = (AdView) findViewById(R.id.adViewlegalAspect);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent( "android_studio:ad_template" ).build();
        adView.loadAd( adRequest );

        //set Home Button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public class myWebclient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            bar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sub,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void closeWindow() {
        finish();
        overridePendingTransition(R.anim.stand_still, R.anim.move_out_to_bottom);
    }

    @Override
    public void onBackPressed() {
        closeWindow();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.share) {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/pain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"NU BBA Syllabus");
            shareIntent.putExtra(Intent.EXTRA_TEXT,getString(R.string.applink));
            startActivity(Intent.createChooser(shareIntent,"Share Via"));
            return true;
        }

        if( id == android.R.id.home) {
            closeWindow();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}