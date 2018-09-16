package com.example.android.mytour;

/**
 * Created by dharm on 07-08-2018.
 */



import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    //Number of tabs
    static final int NUM_ITEMS = 4;

    /**
     * Context of the app
     */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VizagFragment();
            case 1:
                return new AmaravatiFragment();
            case 2:
                return new ChittorFragment();
            case 3:
                return new KurnoolFragment();
            default:
                return new VizagFragment();
        }
    }

    // number of tabs in the view
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_vizag);
            case 1:
                return mContext.getString(R.string.cateory_amaravathi);
            case 2:
                return mContext.getString(R.string.category_chittor);
            case 3:
                return mContext.getString(R.string.category_kurnool);
            default:
                return mContext.getString(R.string.category_kurnool);
        }
    }
}