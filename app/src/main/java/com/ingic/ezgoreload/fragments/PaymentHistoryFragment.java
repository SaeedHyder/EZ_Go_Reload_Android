package com.ingic.ezgoreload.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.PaymentHistoryEnt;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.ui.adapters.ArrayListAdapter;
import com.ingic.ezgoreload.ui.viewbinder.PaymentHistoryBinder;
import com.ingic.ezgoreload.ui.views.AnyTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PaymentHistoryFragment extends BaseFragment {
    @BindView(R.id.txt_start_date)
    AnyTextView txtStartDate;
    @BindView(R.id.txt_end_date)
    AnyTextView txtEndDate;
    @BindView(R.id.listView_card)
    ListView listViewCard;
    private Date StartDatelong;
    private String StartDate;
    private String EndDate;
    private ArrayListAdapter<PaymentHistoryEnt> mAdapter;
    private ArrayList<PaymentHistoryEnt> historycollection;

    public static PaymentHistoryFragment newInstance() {
        return new PaymentHistoryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayListAdapter<PaymentHistoryEnt>(getDockActivity(), new PaymentHistoryBinder());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_payment_history, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindData();
    }

    private void bindData() {
        historycollection = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            historycollection.add(new PaymentHistoryEnt("13-28-17", "8:48 am", "xyz", "10$", "290$"));

        }
        bindView(historycollection);
    }


    private void bindView(final ArrayList<PaymentHistoryEnt> cardscollection) {
        mAdapter.clearList();
        listViewCard.setAdapter(mAdapter);
        mAdapter.addAll(cardscollection);
        mAdapter.notifyDataSetChanged();


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

    @Override
    public void setTitleBar(final TitleBar titleBar) {
        // TODO Auto-generated method stub
        super.setTitleBar(titleBar);
        titleBar.hideButtons();
        titleBar.showBackButton();
        titleBar.showSearchButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleBar.showSearchEditText(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        });
        titleBar.getSearchView().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    UIHelper.hideSoftKeyboard(getDockActivity(),titleBar.getSearchView());
                }
                    return true;
            }
        });
        titleBar.setSubHeading(getString(R.string.payment_history));
    }

    @OnClick({R.id.txt_start_date, R.id.txt_end_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_start_date:
                initDatePicker(txtStartDate, "max", new Date().getTime(), "start");
                break;
            case R.id.txt_end_date:
                if (StartDatelong == null) {
                    UIHelper.showShortToastInCenter(getDockActivity(), "Select Start Date First");
                } else {
                    initDatePicker(txtStartDate, "min", StartDatelong.getTime(), "end");
                }
                break;
        }
    }
}
