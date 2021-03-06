package com.example.angel.viewpager2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by Angel on 09/03/2015.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context contexto;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.contexto = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return contexto.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return contexto.getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return contexto.getString(R.string.title_section3).toUpperCase(l);
        }
        return null;
    }
}
