package Saif.Learning.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import Saif.Learning.R;
import Saif.Learning.core.dashboard.account.AccountFragment;
import Saif.Learning.core.dashboard.home.HomeFragment;
import Saif.Learning.core.dashboard.other.OtherFragment;
import Saif.Learning.core.dashboard.transactional.TransactionalFragment;

import java.util.ArrayList;
import java.util.List;



public class PageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList  = new ArrayList<>();
    private final List<String> mFragmentTitle   = new ArrayList<>();
    Context context;

    public PageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context    = context;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitle.add(title);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitle.get(position);
    }
}
