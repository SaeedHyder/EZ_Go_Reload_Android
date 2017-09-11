package com.ingic.ezgoreload.ui.viewbinder;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.PaymentHistoryEnt;
import com.ingic.ezgoreload.ui.viewbinders.abstracts.ViewBinder;
import com.ingic.ezgoreload.ui.views.AnyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 9/8/2017.
 */

public class PaymentHistoryBinder extends ViewBinder<PaymentHistoryEnt> {
    public PaymentHistoryBinder() {
        super(R.layout.row_item_payment_history);
    }

    @Override
    public BaseViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void bindView(PaymentHistoryEnt entity, int position, int grpPosition, View view, Activity activity) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtDate.setText(entity.getDate());
        holder.txtTime.setText(entity.getTime());
        holder.txtLocation.setText(entity.getLocation());
        holder.txtCreditCharge.setText(entity.getChargedCredit());
        holder.txtCreditLeft.setText(entity.getCreditLeft());
        if ((position % 2) != 0) {
            holder.container.setBackgroundColor(view.getContext().getResources().getColor(R.color.list_inactive_background));
        }
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.txt_date)
        AnyTextView txtDate;
        @BindView(R.id.txt_time)
        AnyTextView txtTime;
        @BindView(R.id.txt_location)
        AnyTextView txtLocation;
        @BindView(R.id.txt_credit_charge)
        AnyTextView txtCreditCharge;
        @BindView(R.id.txt_credit_left)
        AnyTextView txtCreditLeft;
        @BindView(R.id.container)
        LinearLayout container;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
