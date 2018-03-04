package com.tistory.quinoa.coinanalyzer;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener,
CoinInfoFragment.OnCoinInfoFragmentInteractionListener,
CoinAssetFragment.OnCoinAssetFragmentInteractionListener,
CoinNewsFragment.OnCoinNewsFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fab;
    private void setViews(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), this));

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle(getString(R.string.app_name));

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Fab button clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnCoinInfoFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCoinAssetFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCoinNewsFragmentInteraction(Uri uri) {

    }
}
