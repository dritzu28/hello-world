package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import activity.FriendsFragment;
import activity.HomeFragment;
import activity.MessagesFragment;

/**
 * Created by itzu.villarce on 24/10/16.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs){
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment =  new HomeFragment();
                return homeFragment;
            case 1:
                FriendsFragment friendsFragment =  new FriendsFragment();
                return friendsFragment;
            case 2:
                MessagesFragment messagesFragment = new MessagesFragment();
                return messagesFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
