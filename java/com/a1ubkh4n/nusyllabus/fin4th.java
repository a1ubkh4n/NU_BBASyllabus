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

public class fin4th extends AppCompatActivity {
    TextView finfourth;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin4th);

        finfourth = (TextView) findViewById(R.id.finfourth) ;
        Typeface myCustomfons = Typeface.createFromAsset(getAssets(),"fonts/allema.ttf");
        finfourth.setTypeface(myCustomfons);

        Toolbar toolbar = (Toolbar) findViewById( R.id.fin4th );
        setSupportActionBar( toolbar );

        AdView adView = (AdView) findViewById(R.id.adViewfin4th);
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

    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
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

    public void interTrade(View view) {
        Intent i = new Intent(fin4th.this, fin_interna_trade_finan.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void publicFinan(View view) {
        Intent i = new Intent(fin4th.this, fin_public_finan_tax.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void comFinan(View view) {
        Intent i = new Intent(fin4th.this, fin_comparative_financi.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void human_resouc(View view) {
        Intent i = new Intent(fin4th.this, fin_human_resour_manag.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void businesResear(View view) {
        Intent i = new Intent(fin4th.this, fin_business_research_meth.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void smeAndMicro(View view) {
        Intent i = new Intent(fin4th.this, fin_sme_and_micro_fin.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void eBanking(View view) {
        Intent i = new Intent(fin4th.this, fin_e_commer_e_bank.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void centralBanking(View view) {
        Intent i = new Intent(fin4th.this, fin_central_banking.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void finanMarket(View view) {
        Intent i = new Intent(fin4th.this, fin_finance_market.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }
}
