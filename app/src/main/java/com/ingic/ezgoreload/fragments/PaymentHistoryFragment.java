package com.ingic.ezgoreload.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;

import butterknife.ButterKnife;



public class PaymentHistoryFragment extends BaseFragment{
    public static PaymentHistoryFragment newInstance() {
        return new PaymentHistoryFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_payment_history, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

}
