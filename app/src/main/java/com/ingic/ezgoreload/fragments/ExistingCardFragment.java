package com.ingic.ezgoreload.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ExistingCardFragment extends BaseFragment {

    @BindView(R.id.rb_card1)
    RadioButton rb_card1;

    @BindView(R.id.rb_card2)
    RadioButton rb_card2;

    @BindView(R.id.rb_card3)
    RadioButton rb_card3;

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @BindView(R.id.btn_pay)
    Button btn_pay;

    String cardChecker;

    Unbinder unbinder;

    public static ExistingCardFragment newInstance() {
        return new ExistingCardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_existing_card, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardChecker = "NotSelected";
    }


    @Override
    public void setTitleBar(TitleBar titleBar) {
        super.setTitleBar(titleBar);
        titleBar.hideTitleBar();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rb_card1, R.id.rb_card2, R.id.rb_card3, R.id.btn_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_card1:
                cardChecker = "Selected";
                break;
            case R.id.rb_card2:
                cardChecker = "Selected";
                break;
            case R.id.rb_card3:
                cardChecker = "Selected";
                break;
            case R.id.btn_pay:
                if (cardChecker.equals("Selected")) {
                    UIHelper.showLongToastInCenter(getDockActivity(), "Will be implemented in beta.");
                } else {
                    UIHelper.showLongToastInCenter(getDockActivity(), "Please select a card to proceed.");
                }
                break;
        }
    }
}
