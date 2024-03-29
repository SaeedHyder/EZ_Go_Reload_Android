package com.ingic.ezgoreload.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.TransponderEnt;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.interfaces.ListItemClickListener;
import com.ingic.ezgoreload.ui.adapters.ArrayListAdapter;
import com.ingic.ezgoreload.ui.dialogs.DialogFactory;
import com.ingic.ezgoreload.ui.viewbinder.TransponderListBinder;
import com.ingic.ezgoreload.ui.views.TitleBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 9/8/2017.
 */

public class TransponderListFragment extends BaseFragment implements ListItemClickListener {
    @BindView(R.id.listView_card)
    ListView listViewCard;
    private ArrayListAdapter<TransponderEnt> mAdapter;
    private ArrayList<TransponderEnt> cardcollection;

    public static TransponderListFragment newInstance() {
        return new TransponderListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayListAdapter<TransponderEnt>(getDockActivity(), new TransponderListBinder(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_transponder_list, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        bindData();

    }

    private void bindData() {
        cardcollection = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cardcollection.add(new TransponderEnt(("0978942" + i), "XYZ Car", 0));
            cardcollection.add(new TransponderEnt("0978942" + (i + 1), "ABC Car", 0));
        }

        bindView(cardcollection);
    }


    private void bindView(final ArrayList<TransponderEnt> cardscollection) {
        mAdapter.clearList();
        listViewCard.setAdapter(mAdapter);
        mAdapter.addAll(cardscollection);
        mAdapter.notifyDataSetChanged();


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
        titleBar.setSubHeading(getString(R.string.transponder_list));
    }

    @Override
    public void onLongClickListener(Object entity, final int position) {
        Dialog dialog = DialogFactory.createMessageDialog2(getDockActivity(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAdapter.removeItemAtPosition(position);
            }
        }, getString(R.string.delete_Transponder_message), getString(R.string.delete_transponder), R.drawable.app_icon);
        dialog.show();
    }

    @Override
    public void onClickListener(Object entity, int position) {
     /*   Dialog dialog = DialogFactory.createMessageDialog2(getDockActivity(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UIHelper.showShortToastInCenter(getDockActivity(), "Has to be Implemented");
            }
        }, getString(R.string.edit_message), getString(R.string.edit_item_transponder), R.drawable.app_icon);
        dialog.show();*/
    }
}
