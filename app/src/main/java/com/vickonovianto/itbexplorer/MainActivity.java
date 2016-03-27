package com.vickonovianto.itbexplorer;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private MainPortraitFragment mainPort;
    private MainLandscapeFragment mainLand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.maintitle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainPort = new MainPortraitFragment();
        mainPort.setArguments(getIntent().getExtras());
        mainLand = new MainLandscapeFragment();
        mainLand.setArguments(getIntent().getExtras());

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (findViewById(R.id.fragment_container) != null) {
                if (savedInstanceState != null) {
                    return;
                }

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainPort).commit();
            }
        }
        else  if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (findViewById(R.id.fragment_container) != null) {
                if (savedInstanceState != null) {
                    return;
                }

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainLand).commit();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)  {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, mainLand);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, mainPort);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    /** Called when the user clicks the QA button */
    public void gotoQA(View view) {
        Intent intent = new Intent(this, QAActivity.class);
        startActivity(intent);
    }
}
