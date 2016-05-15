package com.example.goko3210.tabbarpager;


import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.githang.navigatordemo.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by goko3210 on 16/5/12.
 */
public class LogonDialog extends DialogFragment implements View.OnClickListener{
    Button weixinLogon;
    Button qqLogon;
    UMShareAPI mShareAPI;
    private UMAuthListener umAuthListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        umAuthListener = new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                Toast.makeText( getActivity().getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                Toast.makeText( getActivity().getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText( getActivity().getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
            }
        };

        mShareAPI = UMShareAPI.get(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.dialog_logon,container,false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        weixinLogon=(Button) view.findViewById(R.id.logon_weixin);
        qqLogon=(Button) view.findViewById(R.id.logon_qq);
//set button color filter
//        weixinLogon.getBackground().setColorFilter(new LightingColorFilter(0x7CCD7C,0x00CD00));
//        qqLogon.getBackground().setColorFilter(new LightingColorFilter(0x1874CD, 0x6495ED));
//set button on click listener
        weixinLogon.setOnClickListener(this);
        qqLogon.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        int myId=v.getId();
        switch (myId) {
            case R.id.logon_qq:
                SHARE_MEDIA platform = SHARE_MEDIA.SINA;
                mShareAPI.doOauthVerify(getActivity(), platform, umAuthListener);
                break;
                //TODO
            case R.id.logon_weixin:
                //TODO
            default:
                //TODO
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        //params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = 500;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
