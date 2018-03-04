package com.tistory.quinoa.coinanalyzer;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kws22 on 2018-03-01.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    List<Fragment> fragments = new ArrayList<>();
    String titles[];

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        titles = new String[]{
                context.getString(R.string.fragment_first),
                context.getString(R.string.fragment_second),
                context.getString(R.string.fragment_third)};
        fragments.add(new CoinInfoFragment());
        fragments.add(new CoinAssetFragment());
        fragments.add(new CoinNewsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return titles[position];
    }

}
