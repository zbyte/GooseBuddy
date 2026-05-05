package com.yftech.settings.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.gs8club.goosebuddy.R;

public class ItemOptionDescribeView extends LinearLayout {
    private final String TAG;
    private String descString;
    private float mPaddingText;
    private String[] mTabTexts;
    private float mTextSize;
    private SwitchMultiButton switchMultiButton;
    private String titleString;
    private String titleStringCN;
    private TextView tvDescribe;
    private TextView tvTitle;

    public ItemOptionDescribeView(@NonNull Context context0) {
        this(context0, null);
    }

    public ItemOptionDescribeView(@NonNull Context context0, @Nullable AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.TAG = this.getClass().getSimpleName();
        this.mTabTexts = new String[]{"L", "R"};
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.ItemOptionDescribeView);
            this.descString = typedArray0.getString(R.styleable.ItemOptionDescribeView_descString);
            this.mPaddingText = typedArray0.getDimension(R.styleable.ItemOptionDescribeView_paddingText, this.getResources().getDimension(R.dimen.multi_button_max_padding_text));  // dimen:multi_button_max_padding_text
            int v = typedArray0.getResourceId(R.styleable.ItemOptionDescribeView_switchTabs, 0);
            this.mTextSize = typedArray0.getDimension(R.styleable.ItemOptionDescribeView_textSize, this.getResources().getDimension(R.dimen.multi_button_text_size));  // dimen:multi_button_text_size
            this.titleString = typedArray0.getString(R.styleable.ItemOptionDescribeView_titleString);
            if(v != 0) {
                this.mTabTexts = this.getResources().getStringArray(v);
            }
            typedArray0.recycle();
            this.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
        }
        this.init();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addOnTouchListener(View.OnTouchListener view$OnTouchListener0) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setOnTouchListener(view$OnTouchListener0);
        }
    }

    public TextView getTvDescribe() {
        return this.tvDescribe;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.item_option_describe, this, true);  // layout:item_option_describe
        this.tvTitle = (TextView)this.findViewById(R.id.tvTitle);  // id:tvTitle
        this.tvDescribe = (TextView)this.findViewById(R.id.tvDescribe);  // id:tvDescribe
        if(TextUtils.isEmpty(this.descString)) {
            this.tvDescribe.setVisibility(View.GONE);
        }
        else {
            this.tvDescribe.setText(this.descString);
            this.tvDescribe.setVisibility(View.VISIBLE);
        }
        this.switchMultiButton = (SwitchMultiButton)this.findViewById(R.id.switchMultiButton);  // id:switchMultiButton
        this.switchMultiButton.setText(this.mTabTexts).setPaddingText(((int)this.mPaddingText), this.mTextSize);
        if(TextUtils.isEmpty(this.titleString)) {
            this.tvTitle.setVisibility(View.INVISIBLE);
            return;
        }
        this.tvTitle.setVisibility(View.VISIBLE);
        this.tvTitle.setText(this.titleString);
        this.switchMultiButton.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
    }

    public void setDescString(CharSequence charSequence0) {
        Log.i(this.TAG, this.getTag() + " >>> setDescString:" + charSequence0);
        if(this.tvDescribe != null) {
            if(TextUtils.isEmpty(charSequence0)) {
                this.tvDescribe.setVisibility(View.GONE);
                return;
            }
            this.tvDescribe.setVisibility(View.VISIBLE);
            this.tvDescribe.setText(charSequence0);
        }
    }

    public void setOnSwitchListener(SwitchMultiButton.OnSwitchListener switchMultiButton$OnSwitchListener0) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setOnSwitchListener(switchMultiButton$OnSwitchListener0);
        }
    }

    public void setPlaySoundEffect(boolean z) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setPlaySoundEffect(z);
        }
    }

    public void setSelectedTab(int v) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setSelectedTab(v);
        }
    }

    public void setSwitchMultiButtonEnable(boolean z) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setEnabled(z);
            this.switchMultiButton.setAlpha((z ? 1.0f : 0.2f));
        }
    }

    public void setTitleString(String s) {
        Log.i(this.TAG, this.getTag() + " >>> setTitleString:" + s);
        this.titleString = s;
        if(this.tvTitle != null) {
            this.tvTitle.setText(s);
        }
    }
}

