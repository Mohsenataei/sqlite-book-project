package com.example.mohsen.firstdayproject;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;

import models.Model;

public class Main2Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
apter         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            TextView mPageTv, mDetailTv, mChpterTv, mTitle ;

            mPageTv = rootView.findViewById(R.id.pageTv);
            mDetailTv = rootView.findViewById(R.id.detailTv);
            mChpterTv = rootView.findViewById(R.id.chapterTv);
            mTitle = rootView.findViewById(R.id.titleTv);

            SqlLiteDbHelper dbHelper;
            ArrayList<Model> modelList;
            int page = 0;
            String chap = null, title = null, details = null;


            modelList = new ArrayList<>();
            modelList.clear();

            dbHelper = new SqlLiteDbHelper(getContext());

            modelList = dbHelper.getDetails();

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1){

                Model count = modelList.get(0);
                page = page + count.getIds();
                chap = chap + count.getChapters();
                title = title + count.getTitles();
                details = details + count.getDetails();

                // set to text views

                mPageTv.setText(page);
                mChpterTv.setText(chap);
                mTitle.setText(title);
                mDetailTv.setText(details);
                return rootView;
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2){

                Model count = modelList.get(1);
                page = page + count.getIds();
                chap = chap + count.getChapters();
                title = title + count.getTitles();
                details = details + count.getDetails();

                // set to text views

                mPageTv.setText(page);
                mChpterTv.setText(chap);
                mTitle.setText(title);
                mDetailTv.setText(details);
                return rootView;
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3){

                Model count = modelList.get(2);
                page = page + count.getIds();
                chap = chap + count.getChapters();
                title = title + count.getTitles();
                details = details + count.getDetails();

                // set to text views

                mPageTv.setText(page);
                mChpterTv.setText(chap);
                mTitle.setText(title);
                mDetailTv.setText(details);
                return rootView;
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 4){

                Model count = modelList.get(3);
                page = page + count.getIds();
                chap = chap + count.getChapters();
                title = title + count.getTitles();
                details = details + count.getDetails();

                // set to text views

                mPageTv.setText(page);
                mChpterTv.setText(chap);
                mTitle.setText(title);
                mDetailTv.setText(details);
                return rootView;
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 5){

                Model count = modelList.get(4);
                page = page + count.getIds();
                chap = chap + count.getChapters();
                title = title + count.getTitles();
                details = details + count.getDetails();

                // set to text views

                mPageTv.setText(page);
                mChpterTv.setText(chap);
                mTitle.setText(title);
                mDetailTv.setText(details);
                return rootView;
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }
    }
}
