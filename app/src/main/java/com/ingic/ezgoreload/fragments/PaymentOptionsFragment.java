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


public class PaymentOptionsFragment extends BaseFragment {

    @BindView(R.id.ll_newCard)
    LinearLayout llNewCard;
    @BindView(R.id.ll_replace)
    LinearLayout llReplace;

    public static PaymentOptionsFragment newInstance() {
        return new PaymentOptionsFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_option, container, false);
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
        titleBar.setSubHeading(getString(R.string.payment_method));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.ll_newCard, R.id.ll_replace})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_newCard:
                getDockActivity().replaceDockableFragment(AddCreditsTabFragment.newInstance(true), "AddCreditsTabFragment");
                break;
            case R.id.ll_replace:
                getDockActivity().replaceDockableFragment(CardListFragment.newInstance(), "CardListFragment");
                break;
        }
    }
}
