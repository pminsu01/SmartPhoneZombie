package hansunguniver.kdelab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import hansunguniver.kdelab.androidtown.MainView;
import hansunguniver.kdelab.androidtown.Setting;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends FragmentActivity {

    MaterialTabHost tabHost;
    ViewPager viewPager;
    ViewPagerAdapter pagerAdapter;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





        tabHost = (MaterialTabHost) findViewById(R.id.tabHost);
        viewPager = (ViewPager) findViewById(R.id.pager);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                tabHost.setSelectedNavigationItem(position);
            }
        });
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            MaterialTab tab = tabHost.newTab();
            tab.setText(pagerAdapter.getPageTitle(i));
            tab.setTabListener(new ProductTabListener());
            tabHost.addTab(tab);
        }

        tabHost.setSelectedNavigationItem(0);
     }
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int index) {
            Fragment frag = null;

            if (index == 0)  {

                frag = new MainView();
            }

            if(index ==1 ) {

                frag = new Setting();
            }

            return frag;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Main";
                case 1:
                    return "Setting";

                default:
                    return null;
            }
        }

    }

    private class ProductTabListener implements MaterialTabListener {

        public ProductTabListener() {

        }

        @Override
        public void onTabSelected(MaterialTab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabReselected(MaterialTab tab) {

        }

        @Override
        public void onTabUnselected(MaterialTab tab) {

        }

    }


    }


