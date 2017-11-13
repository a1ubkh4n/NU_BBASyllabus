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

public class man4th extends AppCompatActivity {
    TextView manfourth;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man4th);

        Toolbar toolbar = (Toolbar) findViewById( R.id.man4th );
        setSupportActionBar( toolbar );

        manfourth = (TextView) findViewById(R.id.manfourth) ;
        Typeface myCustomfons = Typeface.createFromAsset(getAssets(),"fonts/allema.ttf");
        manfourth.setTypeface(myCustomfons);

        AdView adView = (AdView) findViewById(R.id.adViewman4th);
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


    public void bankMange(View view) {
        Intent i = new Intent(man4th.this, man_bankManage.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void finanMang(View view) {
        Intent i = new Intent(man4th.this, financial_manage.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void supplyChain(View view) {
        Intent i = new Intent(man4th.this, supply_chain.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void industraREla(View view) {
        Intent i = new Intent(man4th.this, man_industrial_relations.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void projMan(View view) {
        Intent i = new Intent(man4th.this, man_project_manage.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void interTrad(View view) {
        Intent i = new Intent(man4th.this, man_internatio_trade.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void investManage(View view) {
        Intent i = new Intent(man4th.this, man_investment_manage.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void bdEcono(View view) {
        Intent i = new Intent(man4th.this, man_bangla_econo.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }


    public void enterMan(View view) {
        Intent i = new Intent(man4th.this, enternship.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }
}
