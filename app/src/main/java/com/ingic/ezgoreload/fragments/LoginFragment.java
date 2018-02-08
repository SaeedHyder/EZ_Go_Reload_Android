package com.ingic.ezgoreload.fragments;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.ui.views.AnyEditTextView;
import com.ingic.ezgoreload.ui.views.AnyTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class LoginFragment extends BaseFragment {

    @BindView(R.id.edtUserName)
    AnyEditTextView edtUserName;
    @BindView(R.id.edtpin)
    AnyEditTextView edtpin;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.txt_reset_pin)
    AnyTextView txtResetPin;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void setTitleBar(TitleBar titleBar) {
        // TODO Auto-generated method stub
        super.setTitleBar(titleBar);
        titleBar.hideTitleBar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_login, container, false);
       ButterKnife.bind(this, view);
        return view;

    }




    @OnClick({R.id.btn_login, R.id.btn_register, R.id.txt_reset_pin, R.id.btn_fb, R.id.btn_twitter, R.id.btn_linkedin, R.id.btn_youtube, R.id.btn_insta, R.id.btn_snapchat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (validated()){
                    prefHelper.setLoginStatus(true);
                    getDockActivity().popBackStackTillEntry(0);
                    getDockActivity().replaceDockableFragment(HomeFragment.newInstance(),HomeFragment.class.getSimpleName());
                }
                break;
            case R.id.btn_register:
                getDockActivity().replaceDockableFragment(SignupFragment.newInstance(), "SignupFragment");
                break;
            case R.id.txt_reset_pin:
                UIHelper.showAlertDialog(getString(R.string.reset_pin_message),getString(R.string.reset_pin),getDockActivity());
                break;
            case R.id.btn_fb:
                UIHelper.showShortToastInCenter(getDockActivity(),"Will be Implemented in Beta Version");
                break;
            case R.id.btn_twitter:
                UIHelper.showShortToastInCenter(getDockActivity(),"Will be Implemented in Beta Version");
                break;
            case R.id.btn_linkedin:
                UIHelper.showShortToastInCenter(getDockActivity(),"Will be Implemented in Beta Version");
                break;
            case R.id.btn_youtube:
                UIHelper.showShortToastInCenter(getDockActivity(),"Will be Implemented in Beta Version");
                break;
            case R.id.btn_insta:
                UIHelper.showShortToastInCenter(getDockActivity(),"Will be Implemented in Beta Version");
                break;
            case R.id.btn_snapchat:
                UIHelper.showShortToastInCenter(getDockActivity(),"Will be Implemented in Beta Version");
                break;
        }
    }

    private boolean validated() {
        if (edtUserName.getText() == null || (edtUserName.getText().toString().isEmpty()) ) {
            edtUserName.setError(getString(R.string.enter_valid_username));
            return false;
        } else if (edtpin.getText().toString().isEmpty()) {
            edtpin.setError(getString(R.string.enter_Pin));
            return false;
        } else if (edtpin.getText().toString().length() < 4) {
            edtpin.setError(getString(R.string.pinlenght));
            return false;
        } else {
            return true;
        }
    }
}
