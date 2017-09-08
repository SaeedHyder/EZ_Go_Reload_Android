package com.ingic.ezgoreload.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
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

/**
 * Created on 9/7/2017.
 */

public class AddVehicleFragment extends BaseFragment {
    @BindView(R.id.edtplate)
    AnyEditTextView edtplate;
    @BindView(R.id.edtyear)
    AnyEditTextView edtyear;
    @BindView(R.id.edtfl)
    AnyEditTextView edtfl;
    @BindView(R.id.edtmake)
    AnyEditTextView edtmake;
    @BindView(R.id.edtmodel)
    AnyEditTextView edtmodel;
    @BindView(R.id.edtcolor)
    AnyEditTextView edtcolor;
    @BindView(R.id.btn_startdate)
    AnyTextView btnStartdate;
    @BindView(R.id.btn_enddate)
    AnyTextView btnEnddate;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.check_own_vehicle)
    CheckBox checkOwnVehicle;
    @BindView(R.id.check_rental_vehicle)
    CheckBox checkRentalVehicle;
    @BindView(R.id.date_container)
    LinearLayout dateContainer;
    private Date DateSelected;
    private String StartDate;
    private String EndDate;
    private Date StartDatelong;

    public static AddVehicleFragment newInstance() {
        return new AddVehicleFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        setListener();

    }

    private void setListener() {
        checkOwnVehicle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkRentalVehicle.setChecked(!isChecked);
            }
        });
        checkRentalVehicle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dateContainer.setVisibility(View.VISIBLE);
                } else {
                    dateContainer.setVisibility(View.GONE);
                }
                checkOwnVehicle.setChecked(!isChecked);
            }
        });
    }


    @Override
    public void setTitleBar(TitleBar titleBar) {
        // TODO Auto-generated method stub
        super.setTitleBar(titleBar);
        titleBar.hideButtons();
        titleBar.showBackButton();
        titleBar.showUserButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showShortToastInCenter(getDockActivity(), "has to be implemented");
            }
        });
        titleBar.setSubHeading(getString(R.string.add_vehicle));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_add_vehicle, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    private void initDatePicker(final TextView textView, String type, long date, final String tag) {
        Calendar calendar = Calendar.getInstance();
        final DatePickerHelper datePickerHelper = new DatePickerHelper();
        DatePickerDialog pickerDialog = datePickerHelper.initDateDialog(
                getDockActivity(),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
                , new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.YEAR, year);
                        c.set(Calendar.MONTH, month);
                        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

// and get that as a Date
                        if (false) {//(DateSelected != null && dateSpecified.after(DateSelected)) {
                            UIHelper.showShortToastInCenter(getDockActivity(), "Current Date is Wrong");
                        } else {
                            String predate = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                            textView.setAlpha((float) 1);
                            if (tag.equals("start")) {
                                StartDatelong = c.getTime();
                                StartDate = predate;
                            } else {
                                EndDate = predate;
                            }
                            textView.setText(predate);

                        }

                    }
                }, "PreferredDate");
        if (type.equals("max")) {
            pickerDialog.getDatePicker().setMaxDate(date);
        } else {
            pickerDialog.getDatePicker().setMinDate(date);
        }
        datePickerHelper.showDate();
    }

    @OnClick({R.id.btn_startdate, R.id.btn_enddate, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_startdate:
                initDatePicker(btnStartdate, "max", new Date().getTime(), "start");
                break;
            case R.id.btn_enddate:
                if (StartDatelong == null) {
                    UIHelper.showShortToastInCenter(getDockActivity(), "Select Start Date First");
                } else {
                    initDatePicker(btnEnddate, "min", StartDatelong.getTime(), "end");
                }
                break;
            case R.id.btn_submit:
                if (validate()) {

                }
                break;
        }
    }

    private boolean validate() {
        if (edtplate.getText() == null || (edtplate.getText().toString().isEmpty())) {
            edtplate.setError("Enter Plate Number");
            return false;
        } else if (edtyear.getText().toString().isEmpty()) {
            edtyear.setError("Enter Year");
            return false;
        } else if (edtfl.getText().toString().isEmpty()) {
            edtfl.setError("Enter FL");
            return false;
        } else if (edtmodel.getText().toString().isEmpty()) {
            edtmodel.setError("Enter Model");
            return false;
        } else if (edtmake.getText().toString().isEmpty()) {
            edtmake.setError("Enter Make");
            return false;
        } else if (edtcolor.getText().toString().isEmpty()) {
            edtcolor.setError("Enter Color");
            return false;
        } else if (checkRentalVehicle.isChecked() && btnStartdate.getText().toString().isEmpty()) {
            UIHelper.showShortToastInCenter(getDockActivity(), "Enter Start Date");
            return false;
        } else if (checkRentalVehicle.isChecked() && btnEnddate.getText().toString().isEmpty()) {
            UIHelper.showShortToastInCenter(getDockActivity(), "Enter End Date");
            return false;
        } else {
            return true;
        }

    }


}
