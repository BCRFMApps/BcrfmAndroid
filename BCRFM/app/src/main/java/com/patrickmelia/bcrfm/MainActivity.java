package com.patrickmelia.bcrfm;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


import com.patrickmelia.bcrfm.Fragments.AboutFragment;
import com.patrickmelia.bcrfm.Fragments.ContactFragment;
import com.patrickmelia.bcrfm.Fragments.DeveloperFragment;
import com.patrickmelia.bcrfm.Fragments.FbookFragment;
import com.patrickmelia.bcrfm.Fragments.MediaPlayerNew;
import com.patrickmelia.bcrfm.Fragments.ScheduleFragment;
import com.patrickmelia.bcrfm.Fragments.TweetFragment;
import com.patrickmelia.bcrfm.Fragments.WebSiteFragment;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks{


    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    private CharSequence mTitle;

    private MediaPlayer mp = null;
    private String TAG = getClass().getSimpleName();
    private Button play;
    private Button pause;
    private Button stop;
    private TextView txtVStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);


    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment newFragment = null;
        FragmentManager fragmentManager = getFragmentManager();
        switch (position) {
            case 0:
                newFragment = new MediaPlayerNew(this);
                break;
            case 1: //schedule
                newFragment = new ScheduleFragment();
                break;
            case 2://Website
                newFragment = new WebSiteFragment();
                break;
            case 3://About
                newFragment = new AboutFragment();
                break;
            case 4://Contact
                newFragment = new ContactFragment();
                break;
            case 5:
                newFragment = new DeveloperFragment();
                break;
        }

        fragmentManager.beginTransaction()
                .replace(R.id.container, newFragment)
                .commit();
    }


    public void displayBrowser(String url){
        Uri uri = Uri.parse(url);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setDataAndType(uri, "text/html");
        browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
        this.startActivity(browserIntent);
    }

    public enum cAct{
        Splash, Main, Facebook, Twitter, Sch, About, Contact
    }



    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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


}
