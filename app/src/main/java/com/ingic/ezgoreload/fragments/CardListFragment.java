package com.ingic.ezgoreload.fragments;

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
import com.ingic.ezgoreload.ui.viewbinder.CardListBinder;
import com.ingic.ezgoreload.ui.views.TitleBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 9/7/2017.
 */

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
        for (int i = 0; i < 10; i++) {
            cardcollection.add(new CardEnt("Card - " + i, "Active"));
        }
        bindView(cardcollection);
    }


    private void bindView(ArrayList<CardEnt> cardcollection) {
        mAdapter.clearList();
        listViewCard.setAdapter(mAdapter);
        mAdapter.addAll(cardcollection);
        mAdapter.notifyDataSetChanged();
        listViewCard.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                UIHelper.showShortToastInCenter(getDockActivity(),"item long clicked");
                return false;
            }
        });
        listViewCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UIHelper.showShortToastInCenter(getDockActivity(),"item clicked");
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
                UIHelper.showShortToastInCenter(getDockActivity(), "has to be implemented");
            }
        });
        titleBar.setSubHeading(getString(R.string.card_list));
    }

}
