package com.ingic.ezgoreload.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends BaseFragment {


    @BindView(R.id.ll_addCredit)
    LinearLayout llAddCredit;
    @BindView(R.id.ll_accountOverview)
    LinearLayout llAccountOverview;
    @BindView(R.id.ll_transponders)
    LinearLayout llTransponders;
    @BindView(R.id.ll_vehicles)
    LinearLayout llVehicles;
    @BindView(R.id.ll_paymentOptions)
    LinearLayout llPaymentOptions;
    @BindView(R.id.ll_userInfo)
    LinearLayout llUserInfo;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
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
        titleBar.hideButtons();
        titleBar.showMenuButton();
        titleBar.setTotalBalance("$1059");
        titleBar.setSubHeading(getString(R.string.Home));

    }


}
