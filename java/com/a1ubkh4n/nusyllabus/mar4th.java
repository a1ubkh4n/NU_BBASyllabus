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

import static com.a1ubkh4n.nusyllabus.R.id.accforth;

public class mar4th extends AppCompatActivity {
    TextView martfourth;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mar4th);

        martfourth = (TextView) findViewById(R.id.martfourth) ;
        Typeface myCustomfons = Typeface.createFromAsset(getAssets(),"fonts/allema.ttf");
        martfourth.setTypeface(myCustomfons);

        Toolbar toolbar = (Toolbar) findViewById( R.id.mar4th );
        setSupportActionBar( toolbar );

        AdView adView = (AdView) findViewById(R.id.adViewmar4th);
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


    public void markeManage(View view) {
        Intent i = new Intent(mar4th.this, marketing_management.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void humanMar(View view) {
        Intent i = new Intent(mar4th.this, mar_human_resou_mange.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void interbusinMar(View view) {
        Intent i = new Intent(mar4th.this, mar_interna_business.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void cusBehavi(View view) {
        Intent i = new Intent(mar4th.this, export_import.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void salesManag(View view) {
        Intent i = new Intent(mar4th.this, legal_environ_marke.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void brandMana(View view) {
        Intent i = new Intent(mar4th.this, office_mangement.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void enterDeve(View view) {
        Intent i = new Intent(mar4th.this, funda_inves.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void bdecoMar(View view) {
        Intent i = new Intent(mar4th.this, mar_bangla_econo.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }

    public void markeRecMar(View view) {
        Intent i = new Intent(mar4th.this, innovation_and_newproduct.class );
        startActivity( i );
        overridePendingTransition(R.anim.move_in_from_bottom, R.anim.stand_still);
    }
}
