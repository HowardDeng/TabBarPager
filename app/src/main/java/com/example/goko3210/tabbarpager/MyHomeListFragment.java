package com.example.goko3210.tabbarpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.githang.navigatordemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by goko3210 on 16/5/10.
 */
public class MyHomeListFragment extends Fragment {
    private ListView listview;
    private SimpleAdapter simpleAdapter;
    private int myLayoutId;

    public static final String LAYOUTID = "HomeListLayoutID";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLayoutId=getArguments().getInt(LAYOUTID);

        simpleAdapter = new SimpleAdapter(getActivity(),getData(),myLayoutId,new String[]{"img"},new int[]{R.id.picture});
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.single_listview_layout,container,false);
        listview = (ListView)view.findViewById(R.id.list_view);
        listview.setAdapter(simpleAdapter);

        return view;
    }

    public static MyHomeListFragment getnewInstance(int layoutId)
    {
        MyHomeListFragment myHomeListFragment = new MyHomeListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(LAYOUTID,layoutId);
        myHomeListFragment.setArguments(bundle);
        return myHomeListFragment;
    }

    private List<Map<String,Object>> getData()
    {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("img",R.drawable.myportrait);
        list.add(map);

        return list;
    }
}
