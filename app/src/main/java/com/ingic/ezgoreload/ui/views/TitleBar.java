package com.ingic.ezgoreload.ui.views;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ingic.ezgoreload.R;

public class TitleBar extends RelativeLayout {

	private TextView txtTitle;
	private ImageView btnLeft;
	private ImageView btnRight;
	private TextView txtbalance;
	private RelativeLayout rl_balance;
	private AnyEditTextView searchView;



	private View.OnClickListener menuButtonListener;
	private OnClickListener backButtonListener;

	private Context context;


	public TitleBar(Context context) {
		super(context);
		this.context = context;
		initLayout(context);
	}

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		initLayout(context);
		if (attrs != null)
			initAttrs(context, attrs);
	}

	public TitleBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initLayout(context);
		if (attrs != null)
			initAttrs(context, attrs);
	}

	private void initAttrs(Context context, AttributeSet attrs) {
	}

	private void bindViews() {

		txtTitle = (TextView) this.findViewById(R.id.txt_subHead);
		btnRight = (ImageView) this.findViewById(R.id.btnRight);
		btnLeft = (ImageView) this.findViewById(R.id.btnLeft);
		txtbalance = (TextView) this.findViewById(R.id.txt_balanceTotal);
		rl_balance = (RelativeLayout) this.findViewById(R.id.rl_balance);
		searchView = (AnyEditTextView)this.findViewById(R.id.edtSearch);

	}

	private void initLayout(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.header_main, this);
		bindViews();
	}
	public AnyEditTextView getSearchView(){
		return searchView;
	}

	public void hideButtons() {
		txtTitle.setVisibility(View.GONE);
		btnLeft.setVisibility(View.GONE);
		btnRight.setVisibility(View.GONE);
		rl_balance.setVisibility(View.GONE);
		searchView.setVisibility(View.GONE);


	}

	public void showBackButton() {
		btnLeft.setVisibility(View.VISIBLE);
		btnLeft.setOnClickListener(backButtonListener);
		btnLeft.setImageResource(R.drawable.backicon);
	}
	public void showUserButton(OnClickListener onClickListener) {
		btnRight.setVisibility(View.VISIBLE);
		btnRight.setOnClickListener(onClickListener);
		btnRight.setImageResource(R.drawable.usertop);
	}
	public void showSearchButton(OnClickListener onClickListener) {
		btnRight.setVisibility(View.VISIBLE);
		btnRight.setOnClickListener(onClickListener);
		btnRight.setImageResource(R.drawable.search);
	}
	public void showSearchEditText(TextWatcher textWatcher){
		searchView.setVisibility(View.VISIBLE);
		searchView.addTextChangedListener(textWatcher);
	}

	public void showAddButton(OnClickListener onClickListener) {
		btnRight.setVisibility(View.VISIBLE);
		btnRight.setOnClickListener(onClickListener);
		btnRight.setImageResource(R.drawable.addicon);
	}
	public void showMenuButton() {
		btnLeft.setVisibility(View.VISIBLE);
		btnLeft.setOnClickListener(menuButtonListener);
		btnLeft.setImageResource(R.drawable.sidemenu);
	}

	public void setSubHeading(String heading) {
		txtTitle.setVisibility(View.VISIBLE);
		txtTitle.setText(heading);

	}
	public void setTotalBalance(String balance) {
		rl_balance.setVisibility(View.VISIBLE);
		txtbalance.setText(balance);
	}

	public void showTitleBar() {
		this.setVisibility(View.VISIBLE);
	}

	public void hideTitleBar() {
		this.setVisibility(View.GONE);
	}

	public void setMenuButtonListener(View.OnClickListener listener) {
		menuButtonListener = listener;
	}

	public void setBackButtonListener(View.OnClickListener listener) {
		backButtonListener = listener;
	}



}
