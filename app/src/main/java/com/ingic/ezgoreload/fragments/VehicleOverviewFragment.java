package com.ingic.ezgoreload.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.TransponderEnt;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.interfaces.ListItemClickListener;
import com.ingic.ezgoreload.ui.adapters.ArrayListAdapter;
import com.ingic.ezgoreload.ui.dialogs.DialogFactory;
import com.ingic.ezgoreload.ui.viewbinder.TransponderListBinder;
import com.ingic.ezgoreload.ui.viewbinder.VehicleOverviewBinder;
import com.ingic.ezgoreload.ui.views.TitleBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 9/8/2017.
 */

public class VehicleOverviewFragment extends BaseFragment implements ListItemClickListener {
    @BindView(R.id.listView_card)
    ListView listViewCard;
    private ArrayListAdapter<TransponderEnt> mAdapter;
    private ArrayList<TransponderEnt> cardcollection;

    public static VehicleOverviewFragment newInstance() {
        return new VehicleOverviewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayListAdapter<TransponderEnt>(getDockActivity(), new VehicleOverviewBinder(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_vehicle_list, container, false);
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
            cardcollection.add(new TransponderEnt("Vehicle " + i, "$ 45", 0));
            cardcollection.add(new TransponderEnt("Vehicle " + (i + 1), "$54", 1));
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
        titleBar.showAddButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        titleBar.setSubHeading(getString(R.string.vehicle_overview));
    }

    @Override
    public void onLongClickListener(Object entity, final int position) {
        Dialog dialog = DialogFactory.createMessageDialog2(getDockActivity(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAdapter.removeItemAtPosition(position);
            }
        }, getString(R.string.delete_vehicle_message), getString(R.string.delete_vehicle), R.drawable.app_icon);
        dialog.show();
    }

    @Override
    public void onClickListener(Object entity, int position) {
        Dialog dialog = DialogFactory.createMessageDialog2(getDockActivity(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UIHelper.showShortToastInCenter(getDockActivity(), "Has to be Implemented");
            }
        }, getString(R.string.edit_message), getString(R.string.edit_item), R.drawable.app_icon);
        dialog.show();

    }

}
