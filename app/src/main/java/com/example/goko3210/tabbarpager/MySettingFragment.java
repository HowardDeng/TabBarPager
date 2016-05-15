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
public class MySettingFragment extends BaseFragment{
    private MyListFragment myListFragment;
    private MySettingContainerFragment mySettingContainerFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.fragment_setting,container,false);
        myListFragment = new MyListFragment();
        mySettingContainerFragment = new MySettingContainerFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.first_list_setting,myListFragment).commit();
        fragmentManager.beginTransaction().replace(R.id.second_list_setting,mySettingContainerFragment).commit();
        return view;
    }
}
