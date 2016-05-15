package com.example.goko3210.tabbarpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.githang.navigatordemo.R;

/**
 * Created by goko3210 on 16/5/10.
 */
public class MyHomeFragment extends BaseFragment {
    MyHomeListFragment homeListFragment1;
    MyHomeListFragment homeListFragment2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= getActivity().getLayoutInflater().inflate(R.layout.fragment_home,container,false);
        homeListFragment1=MyHomeListFragment.getnewInstance(R.layout.home_list1);
        homeListFragment2=MyHomeListFragment.getnewInstance(R.layout.home_list2);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.home_frame1,homeListFragment1).commit();
        fm.beginTransaction().replace(R.id.home_frame2,homeListFragment2).commit();

        return view;
    }
}
