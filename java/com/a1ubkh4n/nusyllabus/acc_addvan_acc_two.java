package com.a1ubkh4n.nusyllabus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class acc_addvan_acc_two extends AppCompatActivity {
    WebView webAb;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_addvan_acc_two);

        webAb = (WebView) findViewById(R.id.webacc_addvan_acc_two);
        bar=(ProgressBar) findViewById(R.id.progressBaracc_addvan_acc_two);
        webAb.setWebViewClient(new myWebclient());
        webAb.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webAb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webAb.getSettings().setAppCacheEnabled(true);

        String myurl = "file:///android_asset/www/acc_addvan_acc_two.html";
        webAb.getSettings().setJavaScriptEnabled(true);
        webAb.loadUrl(myurl);

        Toolbar toolbar = (Toolbar) findViewById( R.id.acc_addvan_acc_two );
        setSupportActionBar( toolbar );

        AdView adView = (AdView) findViewById(R.id.adViewacc_addvan_acc_two );
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