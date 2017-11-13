package com.a1ubkh4n.nusyllabus;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class mar1st extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;
    TextView marfirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mar1st);

        marfirst = (TextView) findViewById(R.id.firstmar);
        Typeface myCustomfons = Typeface.createFromAsset(getAssets(), "fonts/allema.ttf");
        marfirst.setTypeface(myCustomfons);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mar1st);
        setSupportActionBar(toolbar);

        AdView adView = (AdView) findViewById(R.id.adViewmar1st);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getString(R.string.interstitiul_add_forSub));
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                displayInterstitial();
            }
        });

        //set Home Button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sub, menu);
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
            Intent messageIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","",null));
            messageIntent.putExtra("sms_body", getString(R.string.applink));
            startActivity(messageIntent);
            return true;
        }

        if (id == android.R.id.home) {
            closeWindow();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void introBus2(View view) {
        Intent i = new Intent(mar1st.this, intro_to_bus_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void prinofmarformar(View view) {
        Intent i = new Intent(mar1st.this, prin_of_mar_for_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void financiAcc(View view) {
        Intent i = new Intent(mar1st.this, financial_acc_for_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void prinofmanformar(View view) {
        Intent i = new Intent(mar1st.this, prin_of_man_for_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void introCompu(View view) {
        Intent i = new Intent(mar1st.this, intro_to_compu_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void hisBd4(View view) {
        Intent i = new Intent(mar1st.this, acc_history_of_the_emer.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }
}