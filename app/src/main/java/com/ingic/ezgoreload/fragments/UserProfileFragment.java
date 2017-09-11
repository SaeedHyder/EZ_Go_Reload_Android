package com.ingic.ezgoreload.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.ui.views.AnyEditTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class UserProfileFragment extends BaseFragment {

    @BindView(R.id.edt_user_name)
    AnyEditTextView edt_user_name;

    @BindView(R.id.edt_address)
    AnyEditTextView edt_address;

    @BindView(R.id.edt_city)
    AnyEditTextView edt_city;

    @BindView(R.id.edt_state)
    AnyEditTextView edt_state;

    @BindView(R.id.edt_country)
    AnyEditTextView edt_country;

    @BindView(R.id.edt_zip_code)
    AnyEditTextView edt_zip_code;

    @BindView(R.id.edt_email)
    AnyEditTextView edt_email;

    @BindView(R.id.edt_phone)
    AnyEditTextView edt_phone;

    @BindView(R.id.edt_mobile)
    AnyEditTextView edt_mobile;

    @BindView(R.id.rb_receipts)
    RadioButton rb_receipts;

    @BindView(R.id.rb_billings)
    RadioButton rb_billings;

    @BindView(R.id.btn_submit_info)
    Button btn_submit_info;

    @BindView(R.id.scrollview_bigdaddy)
    ScrollView scrollview_bigdaddy;

    boolean CheckerBilings;
    boolean CheckerReceipts;

    Unbinder unbinder;

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
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
        titleBar.showMenuButton();
        titleBar.showBackButton();
        titleBar.setSubHeading(getString(R.string.user_profile));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private boolean validate() {
        return edt_user_name.testValidity() && edt_address.testValidity() && edt_city.testValidity() &&
                edt_state.testValidity() && edt_country.testValidity() && edt_zip_code.testValidity() &&
                edt_email.testValidity() && edt_phone.testValidity() && edt_mobile.testValidity();
    }

    @OnClick({R.id.rb_receipts, R.id.rb_billings, R.id.btn_submit_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_receipts:

                if (CheckerReceipts) {
                    rb_receipts.setChecked(true);
                    CheckerReceipts = false;
                } else {
                    rb_receipts.setChecked(false);
                    CheckerReceipts = true;
                }
                break;

            case R.id.rb_billings:

                if (CheckerBilings) {
                    rb_billings.setChecked(true);
                    CheckerBilings = false;
                } else {
                    rb_billings.setChecked(false);
                    CheckerBilings = true;
                }
                break;

            case R.id.btn_submit_info:
                if (validate())
                    if (edt_address.getText().toString().length()<5){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please insert complete address.");
                    } else if (edt_city.getText().toString().length()<3){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please insert complete city name.");
                    } else if (edt_state.getText().toString().length()<3){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please insert complete state name.");
                    } else if (edt_country.getText().toString().length()<3){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please insert complete country name.");
                    } else if (edt_zip_code.getText().toString().length()<3){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please insert complete zip code.");
                    } else if (edt_phone.getText().toString().length()<6){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Phone number should not be less than 6 digits.");
                    } else if (edt_mobile.getText().toString().length()<10){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Mobile number should not be less than 10 digits.");
                    } else {
                        getDockActivity().popFragment();
                    }
                break;
        }
    }
}
