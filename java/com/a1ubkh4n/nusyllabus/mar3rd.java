package com.a1ubkh4n.nusyllabus;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class mar3rd extends AppCompatActivity {
    TextView marthird;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mar3rd);

        marthird = (TextView) findViewById(R.id.marthird) ;
        Typeface myCustomfons = Typeface.createFromAsset(getAssets(),"fonts/allema.ttf");
        marthird.setTypeface(myCustomfons);

        Toolbar toolbar = (Toolbar) findViewById( R.id.mar3rd );
        setSupportActionBar( toolbar );

        AdView adView = (AdView) findViewById(R.id.adViewmar3rd);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent( "android_studio:ad_template" ).build();
        adView.loadAd( adRequest );

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sub,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void closeWindow() {
        finish();
        overridePendingTransition(R.anim.stand_still, R.anim.move_out_to_bottom);
    }

    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
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

        if( id == android.R.id.home) {
            closeWindow();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }


    public void prinMartwo(View view) {
        Intent i = new Intent(mar3rd.this, prin_of_mar_for_mar_two.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void orgaMar(View view) {
        Intent i = new Intent(mar3rd.this, mar_organis_behaviou.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void financiMar(View view) {
        Intent i = new Intent(mar3rd.this, financial_manage_for_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void busstattwo(View view) {
        Intent i = new Intent(mar3rd.this, bus_stats_for_mar_two.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void adverMar(View view) {
        Intent i = new Intent(mar3rd.this, mar_adver_and_promo.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void legalaspectMar(View view) {
        Intent i = new Intent(mar3rd.this, legal_aspects_marketing.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void macroMar(View view) {
        Intent i = new Intent(mar3rd.this, macro_eco_for_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void taxbdMar(View view) {
        Intent i = new Intent(mar3rd.this, tax_in_bd_mar.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);    }
}