package com.example.goko3210.tabbarpager;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.githang.navigatordemo.R;


/**
 * Created by goko3210 on 16/5/10.
 */
public class MyListFragment extends Fragment implements View.OnClickListener {
    private RoundCircleImageView portrait;
    private TextView name;
    private TextView motto;
    LogonDialog logonDialog;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.vlist,container,false);

        portrait =(RoundCircleImageView)view.findViewById(R.id.portrait);
        name =(TextView)view.findViewById(R.id.name);
        motto =(TextView)view.findViewById(R.id.motto);

//        portrait.setImageResource(R.drawable.myportrait);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.myportrait);
        Bitmap bitmapPortrait = Bitmap.createScaledBitmap(bitmap,100,100,false);
        portrait.setImageBitmap(bitmapPortrait);
        name.setText("JohnDeng");
        motto.setText("天道酬勤！！！");

//        portrait.setOnClickListener(this);

        view.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
            if(logonDialog == null)
                logonDialog = new LogonDialog();
            logonDialog.show(getFragmentManager(),"LogonDialog");
    }

}
