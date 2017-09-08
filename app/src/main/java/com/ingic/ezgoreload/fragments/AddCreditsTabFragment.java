package com.ingic.ezgoreload.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.fragments.abstracts.BaseFragment;
import com.ingic.ezgoreload.ui.views.AnyTextView;
import com.ingic.ezgoreload.ui.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.ingic.ezgoreload.activities.DockActivity.KEY_FRAG_FIRST;

public class AddCreditsTabFragment extends BaseFragment {


    @BindView(R.id.tv_new_card)
    AnyTextView tv_new_card;

    @BindView(R.id.view_new_card)
    View view_new_card;

    @BindView(R.id.tv_existing_card)
    AnyTextView tv_existing_card;

    @BindView(R.id.view_existing_card)
    View view_existing_card;

    @BindView(R.id.ll_container)
    LinearLayout ll_container;

    Unbinder unbinder;

    private static boolean checkNewOrExisting;

    public static AddCreditsTabFragment newInstance(boolean isNewOrExisting) {
        checkNewOrExisting = isNewOrExisting;
        return new AddCreditsTabFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_credit_tab, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadingFragment();
    }


    @Override
    public void setTitleBar(TitleBar titleBar) {
        super.setTitleBar(titleBar);
        titleBar.hideButtons();
        titleBar.showBackButton();
        titleBar.setSubHeading(getString(R.string.add_credit));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_new_card, R.id.tv_existing_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_new_card:

                tv_new_card.setAlpha(1);
                view_new_card.setVisibility(View.VISIBLE);
                tv_new_card.setTypeface(Typeface.DEFAULT_BOLD);
                tv_existing_card.setAlpha((float) 0.5);
                view_existing_card.setVisibility(View.GONE);
                ReplaceListViewFragment(NewCardFragment.newInstance());

                break;

            case R.id.tv_existing_card:

                tv_existing_card.setAlpha(1);
                view_existing_card.setVisibility(View.VISIBLE);
                tv_existing_card.setTypeface(Typeface.DEFAULT_BOLD);
                tv_new_card.setAlpha((float) 0.5);
                view_new_card.setVisibility(View.GONE);
                ReplaceListViewFragment(ExistingCardFragment.newInstance());

                break;
        }
    }

    private void ReplaceListViewFragment(BaseFragment frag) {

        FragmentTransaction transaction = getChildFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.ll_container, frag);
        transaction
                .addToBackStack(
                        getChildFragmentManager().getBackStackEntryCount() == 0 ? KEY_FRAG_FIRST
                                : null).commit();
    }

    public void loadingFragment(){
        if (checkNewOrExisting)
        {
            tv_new_card.setAlpha(1);
            view_new_card.setVisibility(View.VISIBLE);
            tv_new_card.setTypeface(Typeface.DEFAULT_BOLD);
            tv_existing_card.setAlpha((float) 0.5);
            view_existing_card.setVisibility(View.GONE);
            ReplaceListViewFragment(NewCardFragment.newInstance());
        }
        else {
            tv_existing_card.setAlpha(1);
            view_existing_card.setVisibility(View.VISIBLE);
            tv_existing_card.setTypeface(Typeface.DEFAULT_BOLD);
            tv_new_card.setAlpha((float) 0.5);
            view_new_card.setVisibility(View.GONE);
            ReplaceListViewFragment(ExistingCardFragment.newInstance());
        }
    }
}
