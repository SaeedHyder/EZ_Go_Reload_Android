package com.ingic.ezgoreload.ui.viewbinder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.ingic.ezgoreload.R;
import com.ingic.ezgoreload.entities.TransponderEnt;
import com.ingic.ezgoreload.interfaces.ListItemClickListener;
import com.ingic.ezgoreload.ui.viewbinders.abstracts.ViewBinder;
import com.ingic.ezgoreload.ui.views.AnySpinner;
import com.ingic.ezgoreload.ui.views.AnyTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 9/8/2017.
 */

public class VehicleOverviewBinder extends ViewBinder<TransponderEnt> {
    private ListItemClickListener itemClickListener;

    public VehicleOverviewBinder(ListItemClickListener listener) {
        super(R.layout.row_item_vehicle_overview);
        itemClickListener = listener;
    }

    @Override
    public BaseViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void bindView(final TransponderEnt entity, final int position, int grpPosition, View view, Activity activity) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtCardName.setText(entity.getCardName() + "");
        holder.txtSnumber.setText(entity.getID() + "");
        setSpinner(view.getContext(), holder.spnStatus, holder.container, entity);

        if (itemClickListener != null) {
            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClickListener(entity, position);
                }
            });
            holder.container.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickListener.onLongClickListener(entity, position);
                    return true;
                }
            });
        }
        /*if (holder.spnStatus.getSelectedItemPosition() == 1) {
            holder.container.setBackgroundColor(view.getContext().getResources().getColor(R.color.list_inactive_background));
        }*/
    }

    private void setSpinner(Context mContext, AnySpinner spinner, final LinearLayout container, final TransponderEnt ent) {

        final ArrayList<String> statusList = new ArrayList<String>();
        statusList.add("Active");
        statusList.add("Inactive");

        ArrayAdapter<String> statusAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, statusList);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(statusAdapter);
        spinner.setSelection(ent.getCardStatus());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ent.setCardStatus(position);
                if (position == 1) {
                    container.setBackgroundColor(view.getContext().getResources().getColor(R.color.list_inactive_background));
                } else {
                    container.setBackgroundColor(view.getContext().getResources().getColor(R.color.white));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    static class ViewHolder extends BaseViewHolder{
        @BindView(R.id.txt_Snumber)
        AnyTextView txtSnumber;
        @BindView(R.id.txt_card_name)
        AnyTextView txtCardName;
        @BindView(R.id.spn_status)
        AnySpinner spnStatus;
        @BindView(R.id.container)
        LinearLayout container;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
