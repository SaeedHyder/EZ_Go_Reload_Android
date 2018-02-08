package com.ingic.ezgoreload.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.CardEnt;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.helpers.UIHelper;
import com.ingic.ezgoreload.ui.adapters.ArrayListAdapter;
import com.ingic.ezgoreload.ui.dialogs.DialogFactory;
import com.ingic.ezgoreload.ui.viewbinder.CardListBinder;
import com.ingic.ezgoreload.ui.views.TitleBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CardListFragment extends BaseFragment {
    @BindView(R.id.listView_card)
    ListView listViewCard;
    private ArrayListAdapter<CardEnt> mAdapter;
    private ArrayList<CardEnt> cardcollection;

    public static CardListFragment newInstance() {
        return new CardListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayListAdapter<CardEnt>(getDockActivity(), new CardListBinder());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);
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
            cardcollection.add(new CardEnt("Card - " + i, "Active"));
            cardcollection.add(new CardEnt("Card - " + (i + 1), "Inactive"));
        }

        bindView(cardcollection);
    }


    private void bindView(final ArrayList<CardEnt> cardscollection) {
        mAdapter.clearList();
        listViewCard.setAdapter(mAdapter);
        mAdapter.addAll(cardscollection);
        mAdapter.notifyDataSetChanged();
        listViewCard.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Dialog dialog = DialogFactory.createMessageDialog2(getDockActivity(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAdapter.removeItemAtPosition(position);
                    }
                }, getString(R.string.delete_card_message), getString(R.string.delete_card), R.drawable.app_icon);
                dialog.show();
                return true;
            }
        });
        listViewCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = DialogFactory.createMessageDialog2(getDockActivity(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDockActivity().replaceDockableFragment(AddCreditsTabFragment.newInstance(true), "AddCreditsTabFragment");
                    }
                }, getString(R.string.edit_message), getString(R.string.edit_item_card), R.drawable.app_icon);
                dialog.show();
            }
        });

    }

    @Override
    public void setTitleBar(TitleBar titleBar) {
        // TODO Auto-generated method stub
        super.setTitleBar(titleBar);
        titleBar.hideButtons();
        titleBar.showBackButton();
        titleBar.showAddButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDockActivity().replaceDockableFragment(AddCreditFragment.newInstance(), "AddCreditFragment");
            }
        });
        titleBar.setSubHeading(getString(R.string.card_list));
    }

}
