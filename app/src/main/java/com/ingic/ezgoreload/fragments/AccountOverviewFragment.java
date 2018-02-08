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


public class AccountOverviewFragment extends BaseFragment {

    @BindView(R.id.ll_payment_history)
    LinearLayout llPaymentHistory;
    @BindView(R.id.ll_userProfile)
    LinearLayout llUserProfile;

    public static AccountOverviewFragment newInstance() {
        return new AccountOverviewFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_overview, container, false);
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
        titleBar.showBackButton();
        titleBar.setSubHeading(getString(R.string.Account_Overview));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.ll_payment_history, R.id.ll_userProfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_payment_history:
                getDockActivity().replaceDockableFragment(PaymentHistoryFragment.newInstance(), "PaymentHistoryFragment");
                break;
            case R.id.ll_userProfile:
                getDockActivity().replaceDockableFragment(UserProfileFragment.newInstance(), "UserProfileFragment");
                break;
        }
    }
}
