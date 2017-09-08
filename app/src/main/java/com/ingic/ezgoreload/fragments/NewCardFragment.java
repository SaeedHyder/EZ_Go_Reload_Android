package com.ingic.ezgoreload.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.DatePickerHelper;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.ui.views.AnyEditTextView;
import com.ingic.ezgoreload.ui.views.AnyTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NewCardFragment extends BaseFragment {

    @BindView(R.id.edt_card_number)
    AnyEditTextView edt_card_number;

    @BindView(R.id.edt_name_on_card)
    AnyEditTextView edt_name_on_card;

    @BindView(R.id.edt_cvv)
    AnyEditTextView edt_cvv;

    @BindView(R.id.edt_zip_code)
    AnyEditTextView edt_zip_code;

    @BindView(R.id.tv_exp_date)
    AnyTextView tv_exp_date;

    @BindView(R.id.rb_replace_credit_card)
    RadioButton rb_replace_credit_card;

    @BindView(R.id.btn_submit)
    Button btn_submit;

    private Date DateSelected;
    boolean CheckerReplaceCard;
    Unbinder unbinder;

    public static NewCardFragment newInstance() {
        return new NewCardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_card, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CheckerReplaceCard = true;
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

    @OnClick({R.id.tv_exp_date, R.id.rb_replace_credit_card, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_exp_date:
                FromDateListner();
                break;
            case R.id.rb_replace_credit_card:
                if (CheckerReplaceCard) {
                    rb_replace_credit_card.setChecked(true);
                    CheckerReplaceCard = false;
                } else {
                    rb_replace_credit_card.setChecked(false);
                    CheckerReplaceCard = true;
                }
                break;
            case R.id.btn_submit:
                if (validate())
                    if (edt_card_number.getText().toString().length()<14){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please insert valid card number.");
                    } else if (edt_cvv.getText().toString().length()<3){
                        UIHelper.showLongToastInCenter(getDockActivity(), "CVV number should be of 3 digits.");
                    } else if (edt_zip_code.getText().toString().length()<3){
                        UIHelper.showLongToastInCenter(getDockActivity(), "Zip code should not be of less than 3 digits.");
                    } else if (tv_exp_date.getText().toString().equals("Expiration Date")) {
                        UIHelper.showLongToastInCenter(getDockActivity(), "Please select Expiration Date.");
                    } else {
                        getDockActivity().replaceDockableFragment(HomeFragment.newInstance(), "HomeFragment"); }
                break;
        }
    }

    private boolean validate() {
        return edt_card_number.testValidity() && edt_name_on_card.testValidity() &&
                edt_cvv.testValidity() && edt_zip_code.testValidity();
    }

    public void FromDateListner() {
        tv_exp_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFromPickerValidated(tv_exp_date);
            }
        });
    }

    private void initFromPickerValidated(final AnyTextView textView) {

        Calendar calendar = Calendar.getInstance();
        final DatePickerHelper datePickerHelper = new DatePickerHelper();
        datePickerHelper.initDateDialog(
                getDockActivity(),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
                , new android.app.DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Date date = new Date();
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.YEAR, year);
                        c.set(Calendar.MONTH, month);
                        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        // and get that as a Date
                        Date dateSpecified = c.getTime();
                        /*if (dateSpecified.after(date)) {
                            UIHelper.showShortToastInCenter(getDockActivity(), "Please enter valid date.");
                        } else {*/
                        DateSelected = dateSpecified;
                        String predate = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

                        textView.setText(predate);
                        textView.setPaintFlags(Typeface.BOLD);
                        //}
                    }
                }, "PreferredDate", new Date());

        datePickerHelper.showDate();
    }
}
