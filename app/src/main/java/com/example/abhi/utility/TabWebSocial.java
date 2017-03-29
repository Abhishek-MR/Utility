package com.example.abhi.utility;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.abhi.utility.web_fragments.FB;
import com.example.abhi.utility.web_fragments.INS;
import com.example.abhi.utility.web_fragments.TW;

import java.util.ArrayList;
import java.util.List;

public class TabWebSocial extends AppCompatActivity {
    public String web;
    private int pos;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    FB fb1 = new FB();
    FB fb2 = new FB();
    FB fb3 = new FB();
    private int[] tabIcons = {
            R.drawable.fb,
            R.drawable.tw,
            R.drawable.ins
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String data = getIntent().getExtras().getString("website");

        setContentView(R.layout.activity_tab_web_social);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        switch (data){
            case "fb" : pos = 0;break;
            case "tw" : pos = 1; break;
            case "ins" : pos = 2; break;
            default: pos = 0; break;
        }
        TabLayout.Tab tab = tabLayout.getTabAt(pos);
        tab.select();
        web = data;
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();
        bundle.putString("webpage", data);
// set Fragmentclass Arguments

        fb1.setArguments(bundle);
        fb2.setArguments(bundle);
        fb3.setArguments(bundle);



    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(fb1, "ONE");
        adapter.addFrag(fb2, "TWO");
        adapter.addFrag(fb3, "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

    }


}
