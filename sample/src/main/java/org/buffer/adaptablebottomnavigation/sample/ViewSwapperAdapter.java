package org.buffer.adaptablebottomnavigation.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.buffer.adaptablebottomnavigation.adapter.FragmentStateAdapter;

public class ViewSwapperAdapter extends FragmentStateAdapter {

    private static final int INDEX_BUFFER = 0;
    private static final int INDEX_RETREAT = 1;
    private static final int INDEX_VALUES = 2;

    public ViewSwapperAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case INDEX_BUFFER:
                return TestFragment.newInstance("");
            case INDEX_RETREAT:
                return Toolsfragment.newInstance("");
            case INDEX_VALUES:
                return SettingsFragment.newInstance("");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
