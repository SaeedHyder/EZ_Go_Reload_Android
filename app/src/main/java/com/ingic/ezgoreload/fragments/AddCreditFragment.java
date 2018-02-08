package com.ingic.ezgoreload.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.ui.views.AnyTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddCreditFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.tv_account_credit)
    AnyTextView tvAccountCredit;
    @BindView(R.id.tv_account_credit_price)
    AnyTextView tvAccountCreditPrice;
    @BindView(R.id.tv_topup_amount)
    AnyTextView tvTopupAmount;
    @BindView(R.id.tv_topup_amount_price)
    AnyTextView tvTopupAmountPrice;
    @BindView(R.id.tv_total_payment)
    AnyTextView tvTotalPayment;
    @BindView(R.id.tv_total_payment_amount)
    AnyTextView tvTotalPaymentAmount;
    @BindView(R.id.btn_recharge)
    Button btnRecharge;

    public static AddCreditFragment newInstance() {
        return new AddCreditFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_credit, container, false);
        unbinder = ButterKnife.bind(this, view);
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
        titleBar.setSubHeading(getString(R.string.add_credit));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_recharge)
    public void onViewClicked() {
        getDockActivity().popFragment();
    }
}
