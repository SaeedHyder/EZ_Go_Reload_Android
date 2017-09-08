package com.ingic.ezgoreload.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.ui.views.AnyTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class SideMenuFragment extends BaseFragment {



    @BindView(R.id.img_profile)
    CircleImageView imgProfile;
    @BindView(R.id.txt_user_profile)
    AnyTextView txtUserProfile;
    @BindView(R.id.txt_account)
    AnyTextView txtAccount;
    @BindView(R.id.btn_home)
    AnyTextView btnHome;
    @BindView(R.id.btn_acount)
    AnyTextView btnAcount;
    @BindView(R.id.btn_transponder)
    AnyTextView btnTransponder;
    @BindView(R.id.btn_payment)
    AnyTextView btnPayment;
    @BindView(R.id.btn_userinfo)
    AnyTextView btnUserinfo;
    @BindView(R.id.btn_logout)
    AnyTextView btnLogout;



    public static SideMenuFragment newInstance() {
        return new SideMenuFragment();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sidemenu, container, false);


         ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void setTitleBar(TitleBar titleBar) {
        super.setTitleBar(titleBar);
        titleBar.hideTitleBar();
    }

    @OnClick({R.id.btn_home, R.id.btn_acount, R.id.btn_transponder, R.id.btn_payment, R.id.btn_userinfo, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                break;
            case R.id.btn_acount:
                break;
            case R.id.btn_transponder:
                break;
            case R.id.btn_payment:
                break;
            case R.id.btn_userinfo:
                break;
            case R.id.btn_logout:
                break;
        }
    }
}
