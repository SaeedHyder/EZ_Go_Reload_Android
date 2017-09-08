package com.ingic.ezgoreload.ui.viewbinder;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.CardEnt;
import com.ingic.ezgoreload.ui.viewbinders.abstracts.ViewBinder;
import com.ingic.ezgoreload.ui.views.AnyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 9/7/2017.
 */

public class CardListBinder extends ViewBinder<CardEnt> {


    public CardListBinder() {
        super(R.layout.row_item_card_list);
    }

    @Override
    public BaseViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void bindView(CardEnt entity, int position, int grpPosition, View view, Activity activity) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtCardName.setText(entity.getCardName() + "");
        holder.txtCardStatus.setText(entity.getCardStatus() + "");
        holder.txtSnumber.setText(position + "");
        if (entity.getCardStatus().contains("Inactive")){
            holder.container.setBackgroundColor(view.getContext().getResources().getColor(R.color.list_inactive_background));
        }
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.txt_Snumber)
        AnyTextView txtSnumber;
        @BindView(R.id.txt_card_name)
        AnyTextView txtCardName;
        @BindView(R.id.txt_card_status)
        AnyTextView txtCardStatus;
        @BindView(R.id.container)
        LinearLayout container;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
