package com.games.radical.icolist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.games.radical.icolist.fragment.IcoListFragment;

/**
 * Created by prajeetshrestha on 2/14/17.
 */

public class IcolistFragmentPagerAdapter extends FragmentPagerAdapter {

    String[] titles;

    public IcolistFragmentPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return new IcoListFragment();
    }

    @Override
    public int getCount() {
        return this.titles.length;
    }


}
