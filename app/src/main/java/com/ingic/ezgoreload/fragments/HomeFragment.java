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
import butterknife.OnClick;


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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.ll_addCredit, R.id.ll_accountOverview, R.id.ll_transponders, R.id.ll_vehicles, R.id.ll_paymentOptions, R.id.ll_userInfo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_addCredit:
                getDockActivity().replaceDockableFragment(AddCreditFragment.newInstance(), "AddCreditFragment");
                break;
            case R.id.ll_accountOverview:
                getDockActivity().replaceDockableFragment(AccountOverviewFragment.newInstance(), "AccountOverviewFragment");
                break;
            case R.id.ll_transponders:
                getDockActivity().replaceDockableFragment(TransponderListFragment.newInstance(), "TransponderListFragment");
                break;
            case R.id.ll_vehicles:
                getDockActivity().replaceDockableFragment(VehicleOverviewFragment.newInstance(), "VehicleOverviewFragment");
                break;
            case R.id.ll_paymentOptions:
                getDockActivity().replaceDockableFragment(PaymentOptionsFragment.newInstance(), "PaymentOptionsFragment");
                break;
            case R.id.ll_userInfo:
                getDockActivity().replaceDockableFragment(AccountOverviewFragment.newInstance(), "AccountOverviewFragment");
                break;
        }
    }
}
